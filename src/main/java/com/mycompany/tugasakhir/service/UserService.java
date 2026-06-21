package com.mycompany.tugasakhir.service;

import com.mycompany.tugasakhir.dao.UserDAO;
import com.mycompany.tugasakhir.model.User;
import com.mycompany.tugasakhir.util.HashUtil;
import com.mycompany.tugasakhir.util.ValidationUtil;

import java.util.List;

/**
 * Service untuk operasi User.
 */
public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public List<User> getAll() {
        return userDAO.findAll();
    }

    public List<User> search(String keyword) {
        return userDAO.search(keyword);
    }

    public User getById(int id) {
        return userDAO.findById(id);
    }

    /**
     * Tambah user baru dengan validasi.
     * @return pesan error jika gagal, null jika berhasil
     */
    public String insert(String nama, String username, String password, String role, String status) {
        // Validasi
        if (ValidationUtil.isEmpty(nama)) return "Nama tidak boleh kosong!";
        if (ValidationUtil.isEmpty(username)) return "Username tidak boleh kosong!";
        if (ValidationUtil.isEmpty(password)) return "Password tidak boleh kosong!";
        if (!ValidationUtil.hasMinLength(password, 4)) return "Password minimal 4 karakter!";
        if (ValidationUtil.isEmpty(role)) return "Role harus dipilih!";

        // Cek duplikat username
        if (userDAO.isUsernameExists(username.trim(), 0)) {
            return "Username sudah digunakan!";
        }

        User user = new User(nama.trim(), username.trim(), HashUtil.sha256(password), role, status);
        if (userDAO.insert(user)) {
            return null; // sukses
        }
        return "Gagal menyimpan data user!";
    }

    /**
     * Update user dengan validasi.
     * @return pesan error jika gagal, null jika berhasil
     */
    public String update(int idUser, String nama, String username, String password, String role, String status) {
        if (ValidationUtil.isEmpty(nama)) return "Nama tidak boleh kosong!";
        if (ValidationUtil.isEmpty(username)) return "Username tidak boleh kosong!";
        if (ValidationUtil.isEmpty(role)) return "Role harus dipilih!";

        // Cek duplikat username (exclude self)
        if (userDAO.isUsernameExists(username.trim(), idUser)) {
            return "Username sudah digunakan!";
        }

        User existing = userDAO.findById(idUser);
        if (existing == null) return "User tidak ditemukan!";

        existing.setNama(nama.trim());
        existing.setUsername(username.trim());
        existing.setRole(role);
        existing.setStatus(status);

        // Update password hanya jika diisi
        if (!ValidationUtil.isEmpty(password)) {
            if (!ValidationUtil.hasMinLength(password, 4)) return "Password minimal 4 karakter!";
            existing.setPasswordHash(HashUtil.sha256(password));
        }

        if (userDAO.update(existing)) {
            return null;
        }
        return "Gagal mengupdate data user!";
    }

    /**
     * Hapus user.
     * @return pesan error jika gagal, null jika berhasil
     */
    public String delete(int idUser) {
        if (userDAO.delete(idUser)) {
            return null;
        }
        return "Gagal menghapus data user! Pastikan user tidak memiliki relasi.";
    }
}
