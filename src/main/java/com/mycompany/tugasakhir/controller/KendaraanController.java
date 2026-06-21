package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.service.KendaraanService;
import com.mycompany.tugasakhir.view.NewKendaraanView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller untuk mengelola data master Kendaraan.
 */
public class KendaraanController {

    private final NewKendaraanView view;
    private final KendaraanService service;

    public KendaraanController(NewKendaraanView view) {
        this.view = view;
        this.service = new KendaraanService();

        // Bind listeners
        this.view.addSaveListener(new SaveListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addResetListener(new ResetListener());
        this.view.addSearchListener(new SearchListener());

        // Initial table load
        refreshTable();
    }

    private void refreshTable() {
        List<Kendaraan> list = service.getAll();
        view.populateTable(list);
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = view.getIdInput();
            String jenis = view.getJenisInput();
            String tarifAwal = view.getTarifAwalInput();
            String tarifPerJam = view.getTarifPerJamInput();
            String status = view.getStatusInput();

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
                JOptionPane.showMessageDialog(com.mycompany.tugasakhir.view.ViewRouter.getCurrentFrame(), "Data kendaraan berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                view.resetForm();
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(com.mycompany.tugasakhir.view.ViewRouter.getCurrentFrame(), errorMsg, "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = view.getIdInput();
            if (idStr.isEmpty()) return;

            int id = Integer.parseInt(idStr);
            int confirm = JOptionPane.showConfirmDialog(com.mycompany.tugasakhir.view.ViewRouter.getCurrentFrame(),
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                String errorMsg = service.delete(id);
                if (errorMsg == null) {
                    JOptionPane.showMessageDialog(com.mycompany.tugasakhir.view.ViewRouter.getCurrentFrame(), "Data kendaraan berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    view.resetForm();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(com.mycompany.tugasakhir.view.ViewRouter.getCurrentFrame(), errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.resetForm();
        }
    }

    private class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String query = view.getSearchInput();
            List<Kendaraan> result;
            if (query.isEmpty()) {
                result = service.getAll();
            } else {
                result = service.search(query);
            }
            view.populateTable(result);
        }
    }
}
