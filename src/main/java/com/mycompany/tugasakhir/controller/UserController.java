package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.User;
import com.mycompany.tugasakhir.service.UserService;
import com.mycompany.tugasakhir.view.panel.UserPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller untuk mengelola data master User.
 */
public class UserController {

    private final UserPanel panel;
    private final UserService service;

    public UserController(UserPanel panel) {
        this.panel = panel;
        this.service = new UserService();

        // Bind listeners
        this.panel.addSaveListener(new SaveListener());
        this.panel.addDeleteListener(new DeleteListener());
        this.panel.addResetListener(new ResetListener());
        this.panel.addSearchListener(new SearchListener());

        // Initial table load
        refreshTable();
    }

    private void refreshTable() {
        List<User> list = service.getAll();
        panel.populateTable(list);
    }

    private class SaveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idStr = panel.getIdInput();
            String nama = panel.getNamaInput();
            String username = panel.getUsernameInput();
            String password = panel.getPasswordInput();
            String role = panel.getRoleInput();
            String status = panel.getStatusInput();

            String errorMsg;

            if (idStr.isEmpty()) {
                // Insert new record
                errorMsg = service.insert(nama, username, password, role, status);
            } else {
                // Update existing record
                int id = Integer.parseInt(idStr);
                errorMsg = service.update(id, nama, username, password, role, status);
            }

            if (errorMsg == null) {
                JOptionPane.showMessageDialog(panel, "Data user berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(panel, "Data user berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
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
            List<User> result;
            if (query.isEmpty()) {
                result = service.getAll();
            } else {
                result = service.search(query);
            }
            panel.populateTable(result);
        }
    }
}
