package com.mycompany.tugasakhir.model;

import java.sql.Timestamp;

/**
 * Model class untuk tabel petugas.
 */
public class Petugas {

    private int idPetugas;
    private String nama;
    private String username;
    private String passwordHash;
    private String role;        // ADMIN, OPERATOR
    private String noTelp;
    private String status;      // AKTIF, NONAKTIF
    private Timestamp createdAt;

    // Default constructor
    public Petugas() {}

    // Constructor lengkap
    public Petugas(int idPetugas, String nama, String username, String passwordHash, String role, String noTelp, String status) {
        this.idPetugas = idPetugas;
        this.nama = nama;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.noTelp = noTelp;
        this.status = status;
    }

    // Constructor untuk insert
    public Petugas(String nama, String username, String passwordHash, String role, String noTelp, String status) {
        this.nama = nama;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.noTelp = noTelp;
        this.status = status;
    }

    // Getter & Setter
    public int getIdPetugas() { return idPetugas; }
    public void setIdPetugas(int idPetugas) { this.idPetugas = idPetugas; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return nama + " (" + role + ")";
    }
}
