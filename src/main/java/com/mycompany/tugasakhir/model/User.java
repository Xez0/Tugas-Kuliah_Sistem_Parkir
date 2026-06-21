package com.mycompany.tugasakhir.model;

import java.sql.Timestamp;

/**
 * Model class untuk tabel users.
 */
public class User {

    private int idUser;
    private String nama;
    private String username;
    private String passwordHash;
    private String role;        // ADMIN, OPERATOR
    private String status;      // AKTIF, NONAKTIF
    private Timestamp createdAt;

    // Default constructor
    public User() {}

    // Constructor lengkap
    public User(int idUser, String nama, String username, String passwordHash, String role, String status) {
        this.idUser = idUser;
        this.nama = nama;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.status = status;
    }

    // Constructor untuk insert (tanpa id)
    public User(String nama, String username, String passwordHash, String role, String status) {
        this.nama = nama;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.status = status;
    }

    // Getter & Setter
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return nama + " (" + username + " - " + role + ")";
    }
}
