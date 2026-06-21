package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.Petugas;
import com.mycompany.tugasakhir.service.PetugasService;
import com.mycompany.tugasakhir.view.NewPetugasView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller untuk mengelola data master Petugas.
 */
public class PetugasController {

    private final NewPetugasView view;
    private final PetugasService service;

    public PetugasController(NewPetugasView view) {
        this.view = view;
        this.service = new PetugasService();

        // Bind listeners
        this.view.addSaveListener(new SaveListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addResetListener(new ResetListener());
        this.view.addSearchListener(new SearchListener());

        // Initial table load
        refreshTable();
    }

    private void refreshTable() {
        List<Petugas> list = service.getAll();
        view.populateTable(list);
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = view.getIdInput();
            String nama = view.getNamaInput();
            String username = view.getUsernameInput();
            String password = view.getPasswordInput();
            String role = view.getRoleInput();
            String noTelp = view.getNoTelpInput();
            String status = view.getStatusInput();

            String errorMsg;

            if (idStr.isEmpty()) {
                // Insert new record
                errorMsg = service.insert(nama, username, password, role, noTelp, status);
            } else {
                // Update existing record
                int id = Integer.parseInt(idStr);
                errorMsg = service.update(id, nama, username, password, role, noTelp, status);
            }

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(view, "Data petugas berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(view, "Data petugas berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
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
            List<Petugas> result;
            if (query.isEmpty()) {
                result = service.getAll();
            } else {
                result = service.search(query);
            }
            view.populateTable(result);
        }
    }
}
