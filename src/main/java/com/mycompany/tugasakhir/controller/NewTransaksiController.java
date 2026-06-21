package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.model.TarifParkir;
import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.service.KendaraanService;
import com.mycompany.tugasakhir.service.TarifParkirService;
import com.mycompany.tugasakhir.service.TransaksiParkirService;
import com.mycompany.tugasakhir.util.CurrencyUtil;
import com.mycompany.tugasakhir.util.DateTimeUtil;
import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.view.NewDashboardView;
import com.mycompany.tugasakhir.view.panel.TransaksiKeluarPanel;
import com.mycompany.tugasakhir.view.panel.TransaksiMasukPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controller untuk mengelola Transaksi Parkir Masuk & Keluar pada NewDashboardView.
 */
public class NewTransaksiController {

    private final TransaksiMasukPanel masukPanel;
    private final TransaksiKeluarPanel keluarPanel;
    private final JFrame parentFrame;

    private final TransaksiParkirService transaksiService;
    private final KendaraanService kendaraanService;
    private final TarifParkirService tarifService;

    public NewTransaksiController(TransaksiMasukPanel masukPanel, TransaksiKeluarPanel keluarPanel, JFrame parentFrame) {
        this.masukPanel = masukPanel;
        this.keluarPanel = keluarPanel;
        this.parentFrame = parentFrame;

        this.transaksiService = new TransaksiParkirService();
        this.kendaraanService = new KendaraanService();
        this.tarifService = new TarifParkirService();

        // Bind Transaksi Masuk listeners
        this.masukPanel.addProsesListener(new ProsesMasukListener());
        this.masukPanel.addResetListener(e -> masukPanel.resetForm());

        // Bind Transaksi Keluar listeners
        this.keluarPanel.addCariListener(new CariActiveListener());
        this.keluarPanel.addProsesKeluarListener(new ProsesKeluarListener());
        this.keluarPanel.addCetakStrukListener(new CetakStrukListener());
        this.keluarPanel.addResetListener(e -> keluarPanel.resetForm());

        // Initial Data Load
        initData();
    }

    private void initData() {
        List<Kendaraan> activeKendaraans = kendaraanService.getAllActive();
        masukPanel.setJenisKendaraanList(activeKendaraans);
        refreshActiveParkingTable();
    }

    private void refreshActiveParkingTable() {
        List<TransaksiParkir> activeList = transaksiService.getAllActive();
        masukPanel.populateActiveParkingTable(activeList);
    }

    private class ProsesMasukListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String plat = masukPanel.getPlatNomorInput();
            Kendaraan k = masukPanel.getSelectedKendaraan();

            if (plat.isEmpty()) {
                JOptionPane.showMessageDialog(masukPanel, "Plat nomor tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (k == null) {
                JOptionPane.showMessageDialog(masukPanel, "Jenis kendaraan belum dipilih!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            TarifParkir tarif = tarifService.getByJenis(k.getJenisKendaraan());
            if (tarif == null) {
                JOptionPane.showMessageDialog(masukPanel, "Tarif progresif untuk jenis kendaraan ini tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LocalDateTime now = LocalDateTime.now();
            String errorMsg = transaksiService.prosesParkirMasuk(plat, k.getIdKendaraan(), tarif.getIdTarif(), now);

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(masukPanel, "Kendaraan " + plat + " berhasil masuk!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                masukPanel.resetForm();
                refreshActiveParkingTable();
            } else {
                JOptionPane.showMessageDialog(masukPanel, errorMsg, "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class CariActiveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String plat = keluarPanel.getCariPlatInput();
            if (plat.isEmpty()) {
                JOptionPane.showMessageDialog(keluarPanel, "Masukkan plat nomor terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            TransaksiParkir t = transaksiService.getActiveByPlat(plat);
            if (t == null) {
                JOptionPane.showMessageDialog(keluarPanel, "Kendaraan dengan plat " + plat + " tidak ditemukan di parkiran!", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            keluarPanel.setTransaksiData(t);

            LocalDateTime now = LocalDateTime.now();
            int durasi = DateTimeUtil.hitungDurasiJam(t.getJamMasuk(), now);
            double biaya = transaksiService.hitungBiayaParkir(t.getTarifAwal(), t.getTarifPerJam(), durasi);
            keluarPanel.setTotalBiaya(biaya);
        }
    }

    private class ProsesKeluarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TransaksiParkir t = keluarPanel.getActiveTransaksi();
            if (t == null) return;

            LocalDateTime jamKeluar = LocalDateTime.now();
            int durasi = DateTimeUtil.hitungDurasiJam(t.getJamMasuk(), jamKeluar);
            double biaya = transaksiService.hitungBiayaParkir(t.getTarifAwal(), t.getTarifPerJam(), durasi);

            String errorMsg = transaksiService.prosesParkirKeluar(t.getIdTransaksi(), jamKeluar);

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(keluarPanel, "Pembayaran berhasil diproses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                TransaksiParkir finalTrans = transaksiService.getById(t.getIdTransaksi());

                String receipt = generateReceiptText(finalTrans);
                keluarPanel.showStruk(receipt);

                refreshActiveParkingTable();
            } else {
                JOptionPane.showMessageDialog(keluarPanel, errorMsg, "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class CetakStrukListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                boolean done = keluarPanel.getStrukArea().print();
                if (done) {
                    JOptionPane.showMessageDialog(keluarPanel, "Struk berhasil dikirim ke printer!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    keluarPanel.resetForm();
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(keluarPanel, "Gagal mencetak struk: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
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
             + " Operator      : " + SessionManager.getCurrentUsername() + "\n"
             + "==========================================\n"
             + " Tarif Awal    : " + CurrencyUtil.formatRupiah(t.getTarifAwal()) + "\n"
             + " Tarif / Jam   : " + CurrencyUtil.formatRupiah(t.getTarifPerJam()) + "\n"
             + "------------------------------------------\n"
             + " TOTAL BIAYA   : " + CurrencyUtil.formatRupiah(t.getTotalBiaya()) + "\n"
             + "==========================================\n"
             + "     Terima Kasih Atas Kunjungan Anda\n"
             + "       Semoga Selamat Sampai Tujuan\n"
             + "==========================================\n";
    }
}
