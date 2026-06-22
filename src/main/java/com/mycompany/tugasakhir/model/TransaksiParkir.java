package com.mycompany.tugasakhir.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Model class untuk tabel transaksi_parkir.
 */
public class TransaksiParkir {

    private int idTransaksi;
    private String platNomor;
    private int idKendaraan;
    private LocalDateTime jamMasuk;
    private LocalDateTime jamKeluar;
    private int durasiJam;
    private double tarifAwal;
    private double tarifPerJam;
    private double totalBiaya;
    private Integer idPetugasMasuk;
    private Integer idPetugasKeluar;
    private String status;          // MASUK, KELUAR
    private Timestamp createdAt;

    // Transient fields (dari JOIN, tidak disimpan di DB)
    private String jenisKendaraan;
    private String namaPetugasMasuk;
    private String namaPetugasKeluar;

    // Default constructor
    public TransaksiParkir() {}

    // Getter & Setter
    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }

    public String getPlatNomor() { return platNomor; }
    public void setPlatNomor(String platNomor) { this.platNomor = platNomor; }

    public int getIdKendaraan() { return idKendaraan; }
    public void setIdKendaraan(int idKendaraan) { this.idKendaraan = idKendaraan; }

    public LocalDateTime getJamMasuk() { return jamMasuk; }
    public void setJamMasuk(LocalDateTime jamMasuk) { this.jamMasuk = jamMasuk; }

    public LocalDateTime getJamKeluar() { return jamKeluar; }
    public void setJamKeluar(LocalDateTime jamKeluar) { this.jamKeluar = jamKeluar; }

    public int getDurasiJam() { return durasiJam; }
    public void setDurasiJam(int durasiJam) { this.durasiJam = durasiJam; }

    public double getTarifAwal() { return tarifAwal; }
    public void setTarifAwal(double tarifAwal) { this.tarifAwal = tarifAwal; }

    public double getTarifPerJam() { return tarifPerJam; }
    public void setTarifPerJam(double tarifPerJam) { this.tarifPerJam = tarifPerJam; }

    public double getTotalBiaya() { return totalBiaya; }
    public void setTotalBiaya(double totalBiaya) { this.totalBiaya = totalBiaya; }

    public Integer getIdPetugasMasuk() { return idPetugasMasuk; }
    public void setIdPetugasMasuk(Integer idPetugasMasuk) { this.idPetugasMasuk = idPetugasMasuk; }

    public Integer getIdPetugasKeluar() { return idPetugasKeluar; }
    public void setIdPetugasKeluar(Integer idPetugasKeluar) { this.idPetugasKeluar = idPetugasKeluar; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    // Transient getters & setters
    public String getJenisKendaraan() { return jenisKendaraan; }
    public void setJenisKendaraan(String jenisKendaraan) { this.jenisKendaraan = jenisKendaraan; }

    public String getNamaPetugasMasuk() { return namaPetugasMasuk; }
    public void setNamaPetugasMasuk(String namaPetugasMasuk) { this.namaPetugasMasuk = namaPetugasMasuk; }

    public String getNamaPetugasKeluar() { return namaPetugasKeluar; }
    public void setNamaPetugasKeluar(String namaPetugasKeluar) { this.namaPetugasKeluar = namaPetugasKeluar; }

    @Override
    public String toString() {
        return "Transaksi [" + platNomor + " - " + status + "]";
    }
}
