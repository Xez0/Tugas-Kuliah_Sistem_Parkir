package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.TarifParkir;
import com.mycompany.tugasakhir.service.TarifParkirService;
import com.mycompany.tugasakhir.view.NewTarifParkirView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller untuk mengelola data master Tarif Parkir.
 */
public class TarifParkirController {

    private final NewTarifParkirView view;
    private final TarifParkirService service;

    public TarifParkirController(NewTarifParkirView view) {
        this.view = view;
        this.service = new TarifParkirService();

        // Bind listeners
        this.view.addSaveListener(new SaveListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addResetListener(new ResetListener());
        this.view.addSearchListener(new SearchListener());

        // Initial table load
        refreshTable();
    }

    private void refreshTable() {
        List<TarifParkir> list = service.getAll();
        view.populateTable(list);
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = view.getIdInput();
            String jenis = view.getJenisInput();
            String tarif = view.getTarifInput();
            String progresif = view.getProgresifInput();
            String status = view.getStatusInput();

            String errorMsg;

            if (idStr.isEmpty()) {
                // Insert new record
                errorMsg = service.insert(jenis, tarif, progresif, status);
            } else {
                // Update existing record
                int id = Integer.parseInt(idStr);
                errorMsg = service.update(id, jenis, tarif, progresif, status);
            }

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(view, "Data tarif berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                view.resetForm();
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(view, errorMsg, "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = view.getIdInput();
            if (idStr.isEmpty()) return;

            int id = Integer.parseInt(idStr);
            int confirm = JOptionPane.showConfirmDialog(
                    view,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                String errorMsg = service.delete(id);
                if (errorMsg == null) {
                    JOptionPane.showMessageDialog(view, "Data tarif berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    view.resetForm();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(view, errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
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
            List<TarifParkir> result;
            if (query.isEmpty()) {
                result = service.getAll();
            } else {
                result = service.search(query);
            }
            view.populateTable(result);
        }
    }
}
