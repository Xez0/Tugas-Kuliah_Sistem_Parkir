package com.mycompany.tugasakhir.model;

/**
 * Model class untuk tabel tarif_parkir.
 */
public class TarifParkir {

    private int idTarif;
    private String jenis;
    private double tarif;
    private double progresif;
    private String status;      // AKTIF, NONAKTIF

    // Default constructor
    public TarifParkir() {}

    // Constructor lengkap
    public TarifParkir(int idTarif, String jenis, double tarif, double progresif, String status) {
        this.idTarif = idTarif;
        this.jenis = jenis;
        this.tarif = tarif;
        this.progresif = progresif;
        this.status = status;
    }

    // Constructor untuk insert
    public TarifParkir(String jenis, double tarif, double progresif, String status) {
        this.jenis = jenis;
        this.tarif = tarif;
        this.progresif = progresif;
        this.status = status;
    }

    // Getter & Setter
    public int getIdTarif() { return idTarif; }
    public void setIdTarif(int idTarif) { this.idTarif = idTarif; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public double getTarif() { return tarif; }
    public void setTarif(double tarif) { this.tarif = tarif; }

    public double getProgresif() { return progresif; }
    public void setProgresif(double progresif) { this.progresif = progresif; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return jenis;
    }
}
