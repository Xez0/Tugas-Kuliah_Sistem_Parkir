package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.model.User;
import com.mycompany.tugasakhir.service.UserService;
import com.mycompany.tugasakhir.view.NewUserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller untuk mengelola data master User.
 */
public class UserController {

    private final NewUserView view;
    private final UserService service;

    public UserController(NewUserView view) {
        this.view = view;
        this.service = new UserService();

        // Bind listeners
        this.view.addSaveListener(new SaveListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addResetListener(new ResetListener());
        this.view.addSearchListener(new SearchListener());

        // Initial table load
        refreshTable();
    }

    private void refreshTable() {
        List<User> list = service.getAll();
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
            String status = view.getStatusInput();

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
                JOptionPane.showMessageDialog(com.mycompany.tugasakhir.view.ViewRouter.getCurrentFrame(), "Data user berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(com.mycompany.tugasakhir.view.ViewRouter.getCurrentFrame(), "Data user berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
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
            List<User> result;
            if (query.isEmpty()) {
                result = service.getAll();
            } else {
                result = service.search(query);
            }
            view.populateTable(result);
        }
    }
}
