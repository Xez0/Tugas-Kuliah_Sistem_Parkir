package com.mycompany.tugasakhir.service;

import com.mycompany.tugasakhir.config.DatabaseConnection;
import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.model.TarifParkir;
import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.util.CurrencyUtil;
import com.mycompany.tugasakhir.view.NewDashboardView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Service untuk menjalankan simulasi demo otomatis pada NewDashboardView.
 */
public class NewDemoService {

    private final NewDashboardView dashboard;
    private final TransaksiParkirService transaksiService;
    private final TarifParkirService tarifService;

    public NewDemoService(NewDashboardView dashboard) {
        this.dashboard = dashboard;
        this.transaksiService = new TransaksiParkirService();
        this.tarifService = new TarifParkirService();
        
        // Pasang listener pada tombol Flying Demo
        this.dashboard.getBtnDemo().addActionListener(e -> startDemo());
    }

    private void startDemo() {
        dashboard.getBtnDemo().setEnabled(false);
        dashboard.getBtnDemo().setText("RUNNING...");

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                com.mycompany.tugasakhir.view.NewTransaksiMasukView masukPanel = com.mycompany.tugasakhir.view.ViewRouter.getTransaksiMasukView();
                com.mycompany.tugasakhir.view.NewTransaksiKeluarView keluarPanel = com.mycompany.tugasakhir.view.ViewRouter.getTransaksiKeluarView();

                // ==========================================
                // TOUR 1: MASTER DATA KENDARAAN (CRUD DEMO)
                // ==========================================
                SwingUtilities.invokeLater(() -> dashboard.showCard("KENDARAAN"));
                Thread.sleep(1500);

                com.mycompany.tugasakhir.view.NewKendaraanView kPanel = com.mycompany.tugasakhir.view.ViewRouter.getKendaraanView();
                com.mycompany.tugasakhir.service.KendaraanService kService = new com.mycompany.tugasakhir.service.KendaraanService();

                // 1. CREATE
                String newVehicle = "HELIKOPTER";
                for (int i = 0; i < newVehicle.length(); i++) {
                    final String currentText = newVehicle.substring(0, i + 1);
                    SwingUtilities.invokeLater(() -> kPanel.getTxtJenis().setText(currentText));
                    Thread.sleep(150);
                }
                
                SwingUtilities.invokeLater(() -> kPanel.getTxtTarifAwal().setText("50000"));
                Thread.sleep(200);
                SwingUtilities.invokeLater(() -> kPanel.getTxtTarifPerJam().setText("10000"));
                Thread.sleep(1000);

                // Simulate Save
                kService.insert(newVehicle, "50000", "10000", "AKTIF");
                SwingUtilities.invokeLater(() -> {
                    kPanel.resetForm();
                    kPanel.populateTable(kService.getAll());
                });
                Thread.sleep(2500); 

                // 2. UPDATE (Change to PESAWAT)
                String updateVehicle = "PESAWAT";
                for (int i = 0; i < updateVehicle.length(); i++) {
                    final String currentText = updateVehicle.substring(0, i + 1);
                    SwingUtilities.invokeLater(() -> kPanel.getTxtJenis().setText(currentText));
                    Thread.sleep(150);
                }
                Thread.sleep(800);
                
                // Find ID
                Kendaraan savedK = kService.getAll().stream().filter(v -> v.getJenisKendaraan().equals("HELIKOPTER")).findFirst().orElse(null);
                if (savedK != null) {
                    kService.update(savedK.getIdKendaraan(), updateVehicle, "55000", "15000", "AKTIF");
                    SwingUtilities.invokeLater(() -> {
                        kPanel.resetForm();
                        kPanel.populateTable(kService.getAll());
                    });
                }
                Thread.sleep(2500);

                // 3. DELETE
                if (savedK != null) {
                    kService.delete(savedK.getIdKendaraan());
                    SwingUtilities.invokeLater(() -> {
                        kPanel.resetForm();
                        kPanel.populateTable(kService.getAll());
                    });
                }
                Thread.sleep(1500);

                // ==========================================
                // TOUR 2: MASTER DATA TARIF
                // ==========================================
                SwingUtilities.invokeLater(() -> dashboard.showCard("TARIF"));
                Thread.sleep(2000);

                // ==========================================
                // TOUR 3: PARKIR MASUK
                // ==========================================
                SwingUtilities.invokeLater(() -> dashboard.showCard("MASUK"));
                Thread.sleep(1500);

                // Type Plate Number
                String plate = "D 3 M O";
                for (int i = 0; i < plate.length(); i++) {
                    final String currentText = plate.substring(0, i + 1);
                    SwingUtilities.invokeLater(() -> masukPanel.getTxtPlatNomor().setText(currentText));
                    Thread.sleep(150);
                }
                Thread.sleep(800);

                // Process Masuk
                List<Kendaraan> activeKendaraan = kService.getAllActive();
                if (activeKendaraan.isEmpty()) {
                    kService.insert("MOBIL DEMO", "5000", "2000", "AKTIF");
                    activeKendaraan = kService.getAllActive();
                }
                
                final List<Kendaraan> finalActive = activeKendaraan;
                SwingUtilities.invokeLater(() -> masukPanel.setJenisKendaraanList(finalActive));
                Thread.sleep(200);
                
                Kendaraan k = activeKendaraan.get(0);
                SwingUtilities.invokeLater(() -> masukPanel.getCbJenisKendaraan().setSelectedItem(k));
                Thread.sleep(500);

                TarifParkir tarif = tarifService.getByJenis(k.getJenisKendaraan());
                if (tarif == null) {
                    tarifService.insert(k.getJenisKendaraan(), String.valueOf(k.getTarifAwal()), String.valueOf(k.getTarifPerJam()), "AKTIF");
                    tarif = tarifService.getByJenis(k.getJenisKendaraan());
                }

                if (k != null && tarif != null) {
                    transaksiService.prosesParkirMasuk(plate, k.getIdKendaraan(), tarif.getIdTarif(), LocalDateTime.now());
                    
                    SwingUtilities.invokeLater(() -> {
                        masukPanel.resetForm();
                        masukPanel.setJenisKendaraanList(finalActive);
                        List<TransaksiParkir> activeList = transaksiService.getAllActive();
                        masukPanel.populateActiveParkingTable(activeList);
                    });
                }

                // ==========================================
                // TOUR 4: MANIPULASI WAKTU PROGRESIF
                // ==========================================
                Thread.sleep(1000);
                manipulateCheckInTime(plate, 6);
                Thread.sleep(500);

                // ==========================================
                // TOUR 5: PARKIR KELUAR
                // ==========================================
                SwingUtilities.invokeLater(() -> dashboard.showCard("KELUAR"));
                Thread.sleep(1500);

                // Type Search Plate
                for (int i = 0; i < plate.length(); i++) {
                    final String currentText = plate.substring(0, i + 1);
                    SwingUtilities.invokeLater(() -> keluarPanel.getTxtCariPlat().setText(currentText));
                    Thread.sleep(150);
                }

                Thread.sleep(500);
                SwingUtilities.invokeLater(() -> keluarPanel.getBtnCari().doClick());

                // Read 6 hours duration
                Thread.sleep(4000);

                // Process Checkout
                TransaksiParkir activeTrans = transaksiService.getActiveByPlat(plate);
                if (activeTrans != null) {
                    LocalDateTime outTime = LocalDateTime.now();
                    transaksiService.prosesParkirKeluar(activeTrans.getIdTransaksi(), outTime);
                    
                    TransaksiParkir finalTrans = transaksiService.getById(activeTrans.getIdTransaksi());
                    String struk = generateReceiptText(finalTrans);
                    
                    SwingUtilities.invokeLater(() -> {
                        keluarPanel.showStruk(struk);
                        List<TransaksiParkir> list = transaksiService.getAllActive();
                        masukPanel.populateActiveParkingTable(list);
                    });
                }

                // Read Struk time
                Thread.sleep(3000);

                // ==========================================
                // TOUR 6: LAPORAN PENDAPATAN
                // ==========================================
                SwingUtilities.invokeLater(() -> {
                    dashboard.showCard("LAPORAN");
                });

                return null;
            }

            @Override
            protected void done() {
                dashboard.getBtnDemo().setText("DEMO");
                dashboard.getBtnDemo().setEnabled(true);
            }
        };

        worker.execute();
    }

    private void manipulateCheckInTime(String platNomor, int hoursAgo) {
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE transaksi_parkir SET jam_masuk = DATE_SUB(NOW(), INTERVAL ? HOUR) WHERE plat_nomor = ? AND status = 'MASUK'")) {
            stmt.setInt(1, hoursAgo);
            stmt.setString(2, platNomor);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String generateReceiptText(TransaksiParkir t) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedMasuk = t.getJamMasuk() != null ? t.getJamMasuk().format(dtf) : "-";
        String formattedKeluar = t.getJamKeluar() != null ? t.getJamKeluar().format(dtf) : "-";
        
        return "==========================================\n"
             + "        STRUK PEMBAYARAN PARKIR\n"
             + "               PARKIRKU\n"
             + "==========================================\n"
             + " No. Transaksi : TR-" + String.format("%05d", t.getIdTransaksi()) + "\n"
             + " Plat Nomor    : " + t.getPlatNomor() + "\n"
             + " Jenis         : " + t.getJenisKendaraan() + "\n"
             + " Jam Masuk     : " + formattedMasuk + "\n"
             + " Jam Keluar    : " + formattedKeluar + "\n"
             + " Durasi        : " + t.getDurasiJam() + " Jam\n"
             + "==========================================\n"
             + " Tarif Awal    : " + CurrencyUtil.formatRupiah(t.getTarifAwal()) + "\n"
             + " Tarif / Jam   : " + CurrencyUtil.formatRupiah(t.getTarifPerJam()) + "\n"
             + "------------------------------------------\n"
             + " TOTAL BIAYA   : " + CurrencyUtil.formatRupiah(t.getTotalBiaya()) + "\n"
             + "==========================================\n"
             + "     Terima Kasih Atas Kunjungan Anda\n"
             + "==========================================\n";
    }
}
