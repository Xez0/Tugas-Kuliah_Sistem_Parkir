package com.mycompany.tugasakhir.service;

import com.mycompany.tugasakhir.dao.KendaraanDAO;
import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.util.ValidationUtil;

import java.util.List;

/**
 * Service untuk operasi Kendaraan.
 */
public class KendaraanService {

    private final KendaraanDAO kendaraanDAO = new KendaraanDAO();

    public List<Kendaraan> getAll() { return kendaraanDAO.findAll(); }
    public List<Kendaraan> getAllActive() { return kendaraanDAO.findAllActive(); }
    public List<Kendaraan> search(String keyword) { return kendaraanDAO.search(keyword); }
    public Kendaraan getById(int id) { return kendaraanDAO.findById(id); }

    public String insert(String jenis, String tarifAwal, String tarifPerJam, String status) {
        if (ValidationUtil.isEmpty(jenis)) return "Jenis kendaraan tidak boleh kosong!";
        if (!ValidationUtil.isPositiveNumber(tarifAwal)) return "Tarif awal harus angka positif!";
        if (!ValidationUtil.isPositiveNumber(tarifPerJam)) return "Tarif per jam harus angka positif!";

        if (kendaraanDAO.isJenisExists(jenis.trim(), 0)) {
            return "Jenis kendaraan sudah ada!";
        }

        Kendaraan kendaraan = new Kendaraan(jenis.trim(),
                Double.parseDouble(tarifAwal.trim()),
                Double.parseDouble(tarifPerJam.trim()), status);
        return kendaraanDAO.insert(kendaraan) ? null : "Gagal menyimpan data kendaraan!";
    }

    public String update(int idKendaraan, String jenis, String tarifAwal, String tarifPerJam, String status) {
        if (ValidationUtil.isEmpty(jenis)) return "Jenis kendaraan tidak boleh kosong!";
        if (!ValidationUtil.isPositiveNumber(tarifAwal)) return "Tarif awal harus angka positif!";
        if (!ValidationUtil.isPositiveNumber(tarifPerJam)) return "Tarif per jam harus angka positif!";

        if (kendaraanDAO.isJenisExists(jenis.trim(), idKendaraan)) {
            return "Jenis kendaraan sudah ada!";
        }

        Kendaraan existing = kendaraanDAO.findById(idKendaraan);
        if (existing == null) return "Kendaraan tidak ditemukan!";

        existing.setJenisKendaraan(jenis.trim());
        existing.setTarifAwal(Double.parseDouble(tarifAwal.trim()));
        existing.setTarifPerJam(Double.parseDouble(tarifPerJam.trim()));
        existing.setStatus(status);

        return kendaraanDAO.update(existing) ? null : "Gagal mengupdate data kendaraan!";
    }

    public String delete(int idKendaraan) {
        return kendaraanDAO.delete(idKendaraan) ? null : "Gagal menghapus data kendaraan! Pastikan tidak ada transaksi terkait.";
    }
}
