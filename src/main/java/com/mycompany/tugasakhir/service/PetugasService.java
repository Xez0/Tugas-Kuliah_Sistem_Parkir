package com.mycompany.tugasakhir.service;

import com.mycompany.tugasakhir.dao.PetugasDAO;
import com.mycompany.tugasakhir.model.Petugas;
import com.mycompany.tugasakhir.util.HashUtil;
import com.mycompany.tugasakhir.util.ValidationUtil;

import java.util.List;

/**
 * Service untuk operasi Petugas.
 */
public class PetugasService {

    private final PetugasDAO petugasDAO = new PetugasDAO();

    public List<Petugas> getAll() { return petugasDAO.findAll(); }
    public List<Petugas> getAllActive() { return petugasDAO.findAllActive(); }
    public List<Petugas> search(String keyword) { return petugasDAO.search(keyword); }
    public Petugas getById(int id) { return petugasDAO.findById(id); }
    public int countAll() { return petugasDAO.countAll(); }

    public String insert(String nama, String username, String password, String role, String noTelp, String status) {
        if (ValidationUtil.isEmpty(nama)) return "Nama tidak boleh kosong!";
        if (ValidationUtil.isEmpty(username)) return "Username tidak boleh kosong!";
        if (ValidationUtil.isEmpty(password)) return "Password tidak boleh kosong!";
        if (!ValidationUtil.hasMinLength(password, 4)) return "Password minimal 4 karakter!";
        if (ValidationUtil.isEmpty(role)) return "Role harus dipilih!";

        if (petugasDAO.isUsernameExists(username.trim(), 0)) {
            return "Username sudah digunakan!";
        }

        Petugas petugas = new Petugas(nama.trim(), username.trim(), HashUtil.sha256(password),
                                       role, noTelp != null ? noTelp.trim() : "", status);
        return petugasDAO.insert(petugas) ? null : "Gagal menyimpan data petugas!";
    }

    public String update(int idPetugas, String nama, String username, String password, String role, String noTelp, String status) {
        if (ValidationUtil.isEmpty(nama)) return "Nama tidak boleh kosong!";
        if (ValidationUtil.isEmpty(username)) return "Username tidak boleh kosong!";
        if (ValidationUtil.isEmpty(role)) return "Role harus dipilih!";

        if (petugasDAO.isUsernameExists(username.trim(), idPetugas)) {
            return "Username sudah digunakan!";
        }

        Petugas existing = petugasDAO.findById(idPetugas);
        if (existing == null) return "Petugas tidak ditemukan!";

        existing.setNama(nama.trim());
        existing.setUsername(username.trim());
        existing.setRole(role);
        existing.setNoTelp(noTelp != null ? noTelp.trim() : "");
        existing.setStatus(status);

        if (!ValidationUtil.isEmpty(password)) {
            if (!ValidationUtil.hasMinLength(password, 4)) return "Password minimal 4 karakter!";
            existing.setPasswordHash(HashUtil.sha256(password));
        }

        return petugasDAO.update(existing) ? null : "Gagal mengupdate data petugas!";
    }

    public String delete(int idPetugas) {
        return petugasDAO.delete(idPetugas) ? null : "Gagal menghapus data petugas! Pastikan petugas tidak memiliki transaksi.";
    }
}
