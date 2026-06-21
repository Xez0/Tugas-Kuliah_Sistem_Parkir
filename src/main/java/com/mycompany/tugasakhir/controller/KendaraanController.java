package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.service.KendaraanService;
import com.mycompany.tugasakhir.view.panel.KendaraanPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller untuk mengelola data master Kendaraan.
 */
public class KendaraanController {

    private final KendaraanPanel panel;
    private final KendaraanService service;

    public KendaraanController(KendaraanPanel panel) {
        this.panel = panel;
        this.service = new KendaraanService();

        // Bind listeners
        this.panel.addSaveListener(new SaveListener());
        this.panel.addDeleteListener(new DeleteListener());
        this.panel.addResetListener(new ResetListener());
        this.panel.addSearchListener(new SearchListener());

        // Initial table load
        refreshTable();
    }

    private void refreshTable() {
        List<Kendaraan> list = service.getAll();
        panel.populateTable(list);
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = panel.getIdInput();
            String jenis = panel.getJenisInput();
            String tarifAwal = panel.getTarifAwalInput();
            String tarifPerJam = panel.getTarifPerJamInput();
            String status = panel.getStatusInput();

            String errorMsg;

            if (idStr.isEmpty()) {
                // Insert new record
                errorMsg = service.insert(jenis, tarifAwal, tarifPerJam, status);
            } else {
                // Update existing record
                int id = Integer.parseInt(idStr);
                errorMsg = service.update(id, jenis, tarifAwal, tarifPerJam, status);
            }

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(panel, "Data kendaraan berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                panel.resetForm();
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(panel, errorMsg, "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = panel.getIdInput();
            if (idStr.isEmpty()) return;

            int id = Integer.parseInt(idStr);
            int confirm = JOptionPane.showConfirmDialog(
                    panel,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                String errorMsg = service.delete(id);
                if (errorMsg == null) {
                    JOptionPane.showMessageDialog(panel, "Data kendaraan berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    panel.resetForm();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(panel, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.resetForm();
        }
    }

    private class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String query = panel.getSearchInput();
            List<Kendaraan> result;
            if (query.isEmpty()) {
                result = service.getAll();
            } else {
                result = service.search(query);
            }
            panel.populateTable(result);
        }
    }
}
