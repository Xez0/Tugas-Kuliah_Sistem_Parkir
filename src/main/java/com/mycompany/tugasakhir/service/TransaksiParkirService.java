package com.mycompany.tugasakhir.service;

import com.mycompany.tugasakhir.dao.KendaraanDAO;
import com.mycompany.tugasakhir.dao.TransaksiParkirDAO;
import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.util.DateTimeUtil;
import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.ValidationUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service untuk operasi Transaksi Parkir.
 * Menangani logika bisnis: parkir masuk, parkir keluar, hitung tarif progresif.
 */
public class TransaksiParkirService {

    private final TransaksiParkirDAO transaksiDAO = new TransaksiParkirDAO();
    private final KendaraanDAO kendaraanDAO = new KendaraanDAO();

    public List<TransaksiParkir> getAll() { return transaksiDAO.findAll(); }
    public List<TransaksiParkir> getAllActive() { return transaksiDAO.findAllActive(); }
    public TransaksiParkir getById(int id) { return transaksiDAO.findById(id); }
    public TransaksiParkir getActiveByPlat(String plat) { return transaksiDAO.findActiveByPlatNomor(plat); }
    public List<TransaksiParkir> searchByPlat(String plat) { return transaksiDAO.searchByPlatNomor(plat); }
    public List<TransaksiParkir> getByDateRange(LocalDate start, LocalDate end) { return transaksiDAO.findByDateRange(start, end); }

    // Dashboard stats
    public int countActiveParking() { return transaksiDAO.countActiveParking(); }
    public int countTodayTransactions() { return transaksiDAO.countTodayTransactions(); }
    public double getTodayRevenue() { return transaksiDAO.getTodayRevenue(); }
    public double getRevenueByDateRange(LocalDate start, LocalDate end) { return transaksiDAO.getRevenueByDateRange(start, end); }

    /**
     * Proses parkir masuk.
     * @return pesan error jika gagal, null jika berhasil
     */
    public String prosesParkirMasuk(String platNomor, int idKendaraan, LocalDateTime jamMasuk, Integer idPetugas) {
        // Validasi
        if (ValidationUtil.isEmpty(platNomor)) return "Plat nomor tidak boleh kosong!";
        if (idKendaraan <= 0) return "Pilih jenis kendaraan!";
        if (jamMasuk == null) return "Jam masuk tidak boleh kosong!";

        String platClean = platNomor.toUpperCase().trim();

        // Cek plat nomor aktif
        if (transaksiDAO.isPlatNomorAktif(platClean)) {
            return "Plat nomor " + platClean + " masih dalam area parkir!";
        }

        // Ambil data kendaraan
        Kendaraan kendaraan = kendaraanDAO.findById(idKendaraan);
        if (kendaraan == null) return "Data kendaraan tidak ditemukan!";

        // Buat transaksi
        TransaksiParkir transaksi = new TransaksiParkir();
        transaksi.setPlatNomor(platClean);
        transaksi.setIdKendaraan(idKendaraan);
        transaksi.setJamMasuk(jamMasuk);
        transaksi.setTarifAwal(kendaraan.getTarifAwal());
        transaksi.setTarifPerJam(kendaraan.getTarifPerJam());
        transaksi.setIdPetugasMasuk(idPetugas != null && idPetugas > 0 ? idPetugas : null);

        boolean success = transaksiDAO.insert(transaksi);
        if (success) {
            return null;
        } else {
            String dbError = transaksiDAO.getLastError();
            return "Gagal menyimpan transaksi parkir masuk!" + (dbError != null ? "\nDetail: " + dbError : "");
        }
    }

    /**
     * Proses parkir keluar.
     * @return pesan error jika gagal, null jika berhasil
     */
    public String prosesParkirKeluar(int idTransaksi, LocalDateTime jamKeluar, Integer idPetugas) {
        if (idTransaksi <= 0) return "Transaksi tidak ditemukan!";
        if (jamKeluar == null) return "Jam keluar tidak boleh kosong!";

        TransaksiParkir transaksi = transaksiDAO.findById(idTransaksi);
        if (transaksi == null) return "Transaksi tidak ditemukan!";
        if ("KELUAR".equals(transaksi.getStatus())) return "Transaksi sudah selesai!";

        // Validasi jam keluar > jam masuk
        if (jamKeluar.isBefore(transaksi.getJamMasuk()) || jamKeluar.isEqual(transaksi.getJamMasuk())) {
            return "Jam keluar harus setelah jam masuk!";
        }

        // Hitung durasi
        int durasi = DateTimeUtil.hitungDurasiJam(transaksi.getJamMasuk(), jamKeluar);

        // Hitung biaya progresif
        double totalBiaya = hitungBiayaParkir(transaksi.getTarifAwal(), transaksi.getTarifPerJam(), durasi);

        // Update transaksi
        transaksi.setJamKeluar(jamKeluar);
        transaksi.setDurasiJam(durasi);
        transaksi.setTotalBiaya(totalBiaya);
        transaksi.setIdPetugasKeluar(idPetugas != null && idPetugas > 0 ? idPetugas : null);

        return transaksiDAO.updateKeluar(transaksi) ? null : "Gagal memproses parkir keluar!";
    }

    /**
     * Hitung biaya parkir progresif.
     *
     * RULE:
     * - Durasi <= 1 jam = tarif_awal
     * - Durasi > 1 jam = tarif_awal + ((durasi - 1) × tarif_per_jam)
     */
    public double hitungBiayaParkir(double tarifAwal, double tarifPerJam, int durasiJam) {
        if (durasiJam <= 0) return 0;
        if (durasiJam <= 1) return tarifAwal;
        return tarifAwal + ((durasiJam - 1) * tarifPerJam);
    }

    /**
     * Hapus transaksi.
     */
    public String delete(int idTransaksi) {
        return transaksiDAO.delete(idTransaksi) ? null : "Gagal menghapus transaksi!";
    }
}
