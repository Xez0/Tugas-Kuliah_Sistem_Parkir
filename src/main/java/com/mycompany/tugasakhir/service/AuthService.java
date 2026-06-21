package com.mycompany.tugasakhir.service;

import com.mycompany.tugasakhir.dao.UserDAO;
import com.mycompany.tugasakhir.model.User;
import com.mycompany.tugasakhir.util.HashUtil;
import com.mycompany.tugasakhir.util.SessionManager;

/**
 * Service untuk autentikasi dan session login.
 */
public class AuthService {

    private final UserDAO userDAO = new UserDAO();

    /**
     * Login user dengan username dan password.
     * @return User jika berhasil, null jika gagal
     */
    public User login(String username, String password) {
        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            return null;
        }

        User user = userDAO.findByUsername(username.trim());
        if (user == null) {
            return null;
        }

        // Cek status aktif
        if (!"AKTIF".equals(user.getStatus())) {
            return null;
        }

        // Verifikasi password hash
        String hashedPassword = HashUtil.sha256(password);
        if (hashedPassword.equals(user.getPasswordHash())) {
            // Set session
            SessionManager.setCurrentUser(user);
            return user;
        }

        return null;
    }

    /**
     * Logout - clear session.
     */
    public void logout() {
        SessionManager.logout();
    }

    /**
     * Cek apakah user sedang login.
     */
    public boolean isLoggedIn() {
        return SessionManager.isLoggedIn();
    }
}
