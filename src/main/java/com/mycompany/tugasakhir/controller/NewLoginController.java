package com.mycompany.tugasakhir.controller;

import com.mycompany.tugasakhir.service.AuthService;
import com.mycompany.tugasakhir.view.NewLoginView;
import com.mycompany.tugasakhir.view.ViewRouter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller untuk Login menggunakan NewLoginView dan NewDashboardView.
 */
public class NewLoginController {

    private final NewLoginView view;
    private final AuthService authService;

    public NewLoginController(NewLoginView view, AuthService authService) {
        this.view = view;
        this.authService = authService;
        
        // Bind event listeners
        this.view.addLoginListener(new LoginListener());
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (username.isEmpty() || password.isEmpty()) {
                view.showErrorMessage("Username dan password tidak boleh kosong!");
                return;
            }

            com.mycompany.tugasakhir.model.User loggedInUser = authService.login(username, password);
            boolean loginSuccess = loggedInUser != null;
            if (loginSuccess) {
                // Close login view
                view.dispose();

                // Open dashboard view in Event Dispatch Thread
                SwingUtilities.invokeLater(() -> {
                    ViewRouter.initializeAllViews();
                    ViewRouter.showView("DASHBOARD", null);
                });
            } else {
                view.showErrorMessage("Username atau password salah / akun nonaktif!");
            }
        }
    }
}
