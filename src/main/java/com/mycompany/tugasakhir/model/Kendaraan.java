package com.mycompany.tugasakhir.model;

/**
 * Model class untuk tabel kendaraan.
 */
public class Kendaraan {

    private int idKendaraan;
    private String jenisKendaraan;
    private double tarifAwal;
    private double tarifPerJam;
    private String status;      // AKTIF, NONAKTIF

    // Default constructor
    public Kendaraan() {}

    // Constructor lengkap
    public Kendaraan(int idKendaraan, String jenisKendaraan, double tarifAwal, double tarifPerJam, String status) {
        this.idKendaraan = idKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.tarifAwal = tarifAwal;
        this.tarifPerJam = tarifPerJam;
        this.status = status;
    }

    // Constructor untuk insert
    public Kendaraan(String jenisKendaraan, double tarifAwal, double tarifPerJam, String status) {
        this.jenisKendaraan = jenisKendaraan;
        this.tarifAwal = tarifAwal;
        this.tarifPerJam = tarifPerJam;
        this.status = status;
    }

    // Getter & Setter
    public int getIdKendaraan() { return idKendaraan; }
    public void setIdKendaraan(int idKendaraan) { this.idKendaraan = idKendaraan; }

    public String getJenisKendaraan() { return jenisKendaraan; }
    public void setJenisKendaraan(String jenisKendaraan) { this.jenisKendaraan = jenisKendaraan; }

    public double getTarifAwal() { return tarifAwal; }
    public void setTarifAwal(double tarifAwal) { this.tarifAwal = tarifAwal; }

    public double getTarifPerJam() { return tarifPerJam; }
    public void setTarifPerJam(double tarifPerJam) { this.tarifPerJam = tarifPerJam; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return jenisKendaraan;
    }
}
