package com.mycompany.tugasakhir.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton Database Connection Manager.
 * Mengelola koneksi JDBC ke MySQL database parkir_db.
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/parkir_db?useSSL=false&serverTimezone=Asia/Jakarta&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("[DB] Koneksi database berhasil.");
        } catch (ClassNotFoundException e) {
            System.err.println("[DB] MySQL JDBC Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("[DB] Gagal koneksi database: " + e.getMessage());
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null || instance.isConnectionClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.err.println("[DB] Error reconnecting: " + e.getMessage());
            throw new RuntimeException("Gagal menyambungkan kembali ke database: " + e.getMessage(), e);
        }
        if (connection == null) {
            throw new RuntimeException("Koneksi database kosong (null). Pastikan server MySQL berjalan.");
        }
        return connection;
    }

    private boolean isConnectionClosed() {
        try {
            return connection == null || connection.isClosed();
        } catch (SQLException e) {
            return true;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("[DB] Koneksi database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("[DB] Error closing connection: " + e.getMessage());
        }
    }
}
