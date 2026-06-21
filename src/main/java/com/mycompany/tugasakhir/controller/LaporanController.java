package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.TransaksiParkir;
import com.mycompany.tugasakhir.service.TransaksiParkirService;
import com.mycompany.tugasakhir.view.NewLaporanView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Controller untuk Panel Laporan.
 * Menangani filter tanggal, pencarian plat, dan cetak tabel laporan.
 */
public class LaporanController {

    private final NewLaporanView view;
    private final TransaksiParkirService service;

    public LaporanController(NewLaporanView view) {
        this.view = view;
        this.service = new TransaksiParkirService();

        // Bind listeners
        this.view.addFilterListener(new FilterListener());
        this.view.addResetListener(new ResetListener());
        this.view.addPrintListener(new PrintListener());

        // Initial load
        executeFilter();
    }

    private void executeFilter() {
        Date startVal = view.getStartDate();
        Date endVal = view.getEndDate();

        if (startVal == null || endVal == null) {
            JOptionPane.showMessageDialog(view, "Tanggal mulai dan akhir harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Convert java.util.Date to java.time.LocalDate
        LocalDate start = startVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = endVal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (start.isAfter(end)) {
            JOptionPane.showMessageDialog(view, "Tanggal mulai tidak boleh melebihi tanggal akhir!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get matching records
        List<TransaksiParkir> records = service.getByDateRange(start, end);
        String searchPlat = view.getSearchPlat();

        if (!searchPlat.isEmpty()) {
            List<TransaksiParkir> filtered = new ArrayList<>();
            for (TransaksiParkir t : records) {
                if (t.getPlatNomor().contains(searchPlat)) {
                    filtered.add(t);
                }
            }
            records = filtered;
        }

        view.populateTable(records);
    }

    private class FilterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            executeFilter();
        }
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetFilters();
            executeFilter();
        }
    }

    private class PrintListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JTable table = view.getTable();
            if (table.getRowCount() == 0) {
                JOptionPane.showMessageDialog(view, "Tidak ada data untuk dicetak!", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                // Style and print layout setup
                MessageFormat header = new MessageFormat("LAPORAN PENDAPATAN PARKIR (" + view.getSearchPlat() + ")");
                MessageFormat footer = new MessageFormat("Halaman {0}");
                
                boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                if (complete) {
                    JOptionPane.showMessageDialog(view, "Laporan berhasil dikirim ke printer!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Gagal mencetak laporan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
