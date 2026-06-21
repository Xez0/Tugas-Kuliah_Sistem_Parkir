package com.mycompany.tugasakhir.service;

import com.mycompany.tugasakhir.dao.TarifParkirDAO;
import com.mycompany.tugasakhir.model.TarifParkir;
import com.mycompany.tugasakhir.util.ValidationUtil;

import java.util.List;

/**
 * Service untuk operasi Tarif Parkir.
 */
public class TarifParkirService {

    private final TarifParkirDAO tarifDAO = new TarifParkirDAO();

    public List<TarifParkir> getAll() { return tarifDAO.findAll(); }
    public List<TarifParkir> getAllActive() { return tarifDAO.findAllActive(); }
    public List<TarifParkir> search(String keyword) { return tarifDAO.search(keyword); }
    public TarifParkir getById(int id) { return tarifDAO.findById(id); }
    public TarifParkir getByJenis(String jenis) { return tarifDAO.findByJenis(jenis); }

    public String insert(String jenis, String tarif, String progresif, String status) {
        if (ValidationUtil.isEmpty(jenis)) return "Jenis tarif tidak boleh kosong!";
        if (!ValidationUtil.isPositiveNumber(tarif)) return "Tarif harus angka positif!";
        if (!ValidationUtil.isPositiveNumber(progresif)) return "Progresif harus angka positif!";

        if (tarifDAO.isJenisExists(jenis.trim(), 0)) {
            return "Jenis tarif sudah ada!";
        }

        TarifParkir tp = new TarifParkir(jenis.trim(),
                Double.parseDouble(tarif.trim()),
                Double.parseDouble(progresif.trim()), status);
        return tarifDAO.insert(tp) ? null : "Gagal menyimpan data tarif!";
    }

    public String update(int idTarif, String jenis, String tarif, String progresif, String status) {
        if (ValidationUtil.isEmpty(jenis)) return "Jenis tarif tidak boleh kosong!";
        if (!ValidationUtil.isPositiveNumber(tarif)) return "Tarif harus angka positif!";
        if (!ValidationUtil.isPositiveNumber(progresif)) return "Progresif harus angka positif!";

        if (tarifDAO.isJenisExists(jenis.trim(), idTarif)) {
            return "Jenis tarif sudah ada!";
        }

        TarifParkir existing = tarifDAO.findById(idTarif);
        if (existing == null) return "Tarif tidak ditemukan!";

        existing.setJenis(jenis.trim());
        existing.setTarif(Double.parseDouble(tarif.trim()));
        existing.setProgresif(Double.parseDouble(progresif.trim()));
        existing.setStatus(status);

        return tarifDAO.update(existing) ? null : "Gagal mengupdate data tarif!";
    }

    public String delete(int idTarif) {
        return tarifDAO.delete(idTarif) ? null : "Gagal menghapus data tarif! Pastikan tidak ada transaksi terkait.";
    }
}
