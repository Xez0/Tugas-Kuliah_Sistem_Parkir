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
import com.mycompany.tugasakhir.view.NewTransaksiMasukView;
import com.mycompany.tugasakhir.view.NewTransaksiKeluarView;

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

    private final NewTransaksiMasukView masukView;
    private final NewTransaksiKeluarView keluarView;

    private final TransaksiParkirService transaksiService;
    private final KendaraanService kendaraanService;
    private final TarifParkirService tarifService;

    public NewTransaksiController(NewTransaksiMasukView masukView, NewTransaksiKeluarView keluarView) {
        this.masukView = masukView;
        this.keluarView = keluarView;

        this.transaksiService = new TransaksiParkirService();
        this.kendaraanService = new KendaraanService();
        this.tarifService = new TarifParkirService();

        // Bind Transaksi Masuk listeners
        this.masukView.addProsesListener(new ProsesMasukListener());
        this.masukView.addResetListener(e -> masukView.resetForm());

        // Bind Transaksi Keluar listeners
        this.keluarView.addCariListener(new CariActiveListener());
        this.keluarView.addProsesKeluarListener(new ProsesKeluarListener());
        this.keluarView.addCetakStrukListener(new CetakStrukListener());
        this.keluarView.addResetListener(e -> keluarView.resetForm());

        // Initial Data Load
        initData();
    }

    private void initData() {
        List<Kendaraan> activeKendaraans = kendaraanService.getAllActive();
        masukView.setJenisKendaraanList(activeKendaraans);
        refreshActiveParkingTable();
    }

    private void refreshActiveParkingTable() {
        List<TransaksiParkir> activeList = transaksiService.getAllActive();
        masukView.populateActiveParkingTable(activeList);
    }

    private class ProsesMasukListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String plat = masukView.getPlatNomorInput();
            Kendaraan k = masukView.getSelectedKendaraan();

            if (plat.isEmpty()) {
                JOptionPane.showMessageDialog(masukView, "Plat nomor tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (k == null) {
                JOptionPane.showMessageDialog(masukView, "Jenis kendaraan belum dipilih!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            TarifParkir tarif = tarifService.getByJenis(k.getJenisKendaraan());
            if (tarif == null) {
                JOptionPane.showMessageDialog(masukView, "Tarif progresif untuk jenis kendaraan ini tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            LocalDateTime now = LocalDateTime.now();
            String errorMsg = transaksiService.prosesParkirMasuk(plat, k.getIdKendaraan(), tarif.getIdTarif(), now);

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(masukView, "Kendaraan " + plat + " berhasil masuk!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                masukView.resetForm();
                refreshActiveParkingTable();
            } else {
                JOptionPane.showMessageDialog(masukView, errorMsg, "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class CariActiveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String plat = keluarView.getCariPlatInput();
            if (plat.isEmpty()) {
                JOptionPane.showMessageDialog(keluarView, "Masukkan plat nomor terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            TransaksiParkir t = transaksiService.getActiveByPlat(plat);
            if (t == null) {
                JOptionPane.showMessageDialog(keluarView, "Kendaraan dengan plat " + plat + " tidak ditemukan di parkiran!", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            keluarView.setTransaksiData(t);

            LocalDateTime now = LocalDateTime.now();
            int durasi = DateTimeUtil.hitungDurasiJam(t.getJamMasuk(), now);
            double biaya = transaksiService.hitungBiayaParkir(t.getTarifAwal(), t.getTarifPerJam(), durasi);
            keluarView.setTotalBiaya(biaya);
        }
    }

    private class ProsesKeluarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            TransaksiParkir t = keluarView.getActiveTransaksi();
            if (t == null) return;

            LocalDateTime jamKeluar = LocalDateTime.now();
            int durasi = DateTimeUtil.hitungDurasiJam(t.getJamMasuk(), jamKeluar);
            double biaya = transaksiService.hitungBiayaParkir(t.getTarifAwal(), t.getTarifPerJam(), durasi);

            String errorMsg = transaksiService.prosesParkirKeluar(t.getIdTransaksi(), jamKeluar);

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(keluarView, "Pembayaran berhasil diproses!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                TransaksiParkir finalTrans = transaksiService.getById(t.getIdTransaksi());

                String receipt = generateReceiptText(finalTrans);
                keluarView.showStruk(receipt);

                refreshActiveParkingTable();
            } else {
                JOptionPane.showMessageDialog(keluarView, errorMsg, "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class CetakStrukListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                boolean done = keluarView.getStrukArea().print();
                if (done) {
                    JOptionPane.showMessageDialog(keluarView, "Struk berhasil dikirim ke printer!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    keluarView.resetForm();
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(keluarView, "Gagal mencetak struk: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
