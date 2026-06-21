package com.mycompany.tugasakhir.util;

import com.mycompany.tugasakhir.model.User;

/**
 * Mengelola session user yang sedang login.
 * Menyimpan data user aktif secara static.
 */
public class SessionManager {

    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static boolean isAdmin() {
        return currentUser != null && "ADMIN".equals(currentUser.getRole());
    }

    public static boolean isOperator() {
        return currentUser != null && "OPERATOR".equals(currentUser.getRole());
    }

    public static String getCurrentUsername() {
        return currentUser != null ? currentUser.getUsername() : "Unknown";
    }

    public static String getCurrentRole() {
        return currentUser != null ? currentUser.getRole() : "Unknown";
    }

    public static int getCurrentUserId() {
        return currentUser != null ? currentUser.getIdUser() : 0;
    }

    public static void logout() {
        currentUser = null;
    }
}
