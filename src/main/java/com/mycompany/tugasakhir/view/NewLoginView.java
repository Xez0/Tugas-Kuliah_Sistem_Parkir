package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewLoginView extends javax.swing.JFrame {

    public NewLoginView() {
        initComponents();
        lblLogo.setIcon(new VectorIcon(VectorIcon.Type.KENDARAAN, 80, Color.WHITE));
        
        // Gradient styling left panel
        leftPanel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(26, 26, 46), 
                        getWidth(), getHeight(), new Color(15, 52, 96)
                );
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(new Color(233, 69, 96, 40));
                g2.fillOval(-50, -50, 200, 200);
                g2.fillOval(getWidth() - 100, getHeight() - 100, 150, 150);
                g2.dispose();
            }
        };
        
        // Style masuk button
        btnLogin.setBackground(new Color(233, 69, 96));
        btnLogin.setForeground(Color.WHITE);
        
        setSize(800, 500);
        setLocationRelativeTo(null);
    }

    public String getUsername() { return txtUsername.getText().trim(); }
    public String getPassword() { return new String(txtPassword.getPassword()); }

    public void addLoginListener(ActionListener l) {
        btnLogin.addActionListener(l);
        txtUsername.addActionListener(l);
        txtPassword.addActionListener(l);
    }

    public void showErrorMessage(String msg) { lblError.setText(msg); }
    public void clearFields() {
        txtUsername.setText("");
        txtPassword.setText("");
        lblError.setText("");
        txtUsername.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        leftPanel = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblSubWelcome = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Login");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        leftPanel.setBackground(new java.awt.Color(26, 26, 46));
        leftPanel.setLayout(new java.awt.GridBagLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        leftPanel.add(lblLogo, gridBagConstraints);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("PARKIR SYSTEM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        leftPanel.add(lblTitle, gridBagConstraints);

        lblSub.setForeground(new java.awt.Color(223, 230, 227));
        lblSub.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSub.setText("Aplikasi Manajemen Parkir Modern & Profesional");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        leftPanel.add(lblSub, gridBagConstraints);

        lblFooter.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        lblFooter.setForeground(new java.awt.Color(178, 190, 195));
        lblFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter.setText("Tugas Akhir Mahasiswa v1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(50, 20, 10, 20);
        leftPanel.add(lblFooter, gridBagConstraints);

        getContentPane().add(leftPanel);

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setLayout(new java.awt.GridBagLayout());

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(45, 52, 54));
        lblWelcome.setText("Selamat Datang");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 40);
        rightPanel.add(lblWelcome, gridBagConstraints);

        lblSubWelcome.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubWelcome.setForeground(new java.awt.Color(99, 110, 115));
        lblSubWelcome.setText("Silakan masuk menggunakan akun Anda");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 20, 40);
        rightPanel.add(lblSubWelcome, gridBagConstraints);

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUser.setForeground(new java.awt.Color(99, 110, 115));
        lblUser.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 40);
        rightPanel.add(lblUser, gridBagConstraints);

        txtUsername.setPreferredSize(new java.awt.Dimension(280, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 10, 40);
        rightPanel.add(txtUsername, gridBagConstraints);

        lblPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPass.setForeground(new java.awt.Color(99, 110, 115));
        lblPass.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 5, 40);
        rightPanel.add(lblPass, gridBagConstraints);

        txtPassword.setPreferredSize(new java.awt.Dimension(280, 40));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 15, 40);
        rightPanel.add(txtPassword, gridBagConstraints);

        lblError.setForeground(new java.awt.Color(214, 48, 49));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 10, 40);
        rightPanel.add(lblError, gridBagConstraints);

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setText("MASUK");
        btnLogin.setPreferredSize(new java.awt.Dimension(280, 45));
        btnLogin.addActionListener(this::btnLoginActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 40);
        rightPanel.add(btnLogin, gridBagConstraints);

        getContentPane().add(rightPanel);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblSubWelcome;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
