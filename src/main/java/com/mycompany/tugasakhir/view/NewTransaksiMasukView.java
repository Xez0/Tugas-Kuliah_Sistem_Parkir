package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.VectorIcon;
import com.mycompany.tugasakhir.view.component.HeaderPanel;
import com.mycompany.tugasakhir.view.component.NavButton;
import com.mycompany.tugasakhir.view.panel.TransaksiMasukPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * JFrame Form untuk menu Parkir Masuk.
 */
public class NewTransaksiMasukView extends javax.swing.JFrame {

    private final Map<String, NavButton> navButtons = new HashMap<>();
    private String currentCardName = "MASUK";

    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;

    public NewTransaksiMasukView() {
        initComponents();
        
        // Setup Icon dan Detail tombol navigasi secara dinamis
        initNavButtonStates();
        
        // Bangun JMenuBar programmatik
        buildMenuBar();
        
        // Setup Access Control berdasarkan role user
        setupAccessControl();
        
        // Atur posisi tengah layar dan ukuran minimum
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
    }

    private void initNavButtonStates() {
        lblAppTitle.setIcon(new VectorIcon(VectorIcon.Type.KENDARAAN, 24, Color.WHITE));
        
        btnDashboard.setCardName("DASHBOARD");
        btnDashboard.setIconType(VectorIcon.Type.DASHBOARD);
        btnDashboard.addActionListener(e -> showCard("DASHBOARD"));
        navButtons.put("DASHBOARD", btnDashboard);
        
        btnMasuk.setCardName("MASUK");
        btnMasuk.setIconType(VectorIcon.Type.MASUK);
        btnMasuk.addActionListener(e -> showCard("MASUK"));
        navButtons.put("MASUK", btnMasuk);
        
        btnKeluar.setCardName("KELUAR");
        btnKeluar.setIconType(VectorIcon.Type.KELUAR);
        btnKeluar.addActionListener(e -> showCard("KELUAR"));
        navButtons.put("KELUAR", btnKeluar);
        
        btnKendaraan.setCardName("KENDARAAN");
        btnKendaraan.setIconType(VectorIcon.Type.KENDARAAN);
        btnKendaraan.addActionListener(e -> showCard("KENDARAAN"));
        navButtons.put("KENDARAAN", btnKendaraan);
        
        btnTarif.setCardName("TARIF");
        btnTarif.setIconType(VectorIcon.Type.TARIF);
        btnTarif.addActionListener(e -> showCard("TARIF"));
        navButtons.put("TARIF", btnTarif);
        
        btnPetugas.setCardName("PETUGAS");
        btnPetugas.setIconType(VectorIcon.Type.PETUGAS);
        btnPetugas.addActionListener(e -> showCard("PETUGAS"));
        navButtons.put("PETUGAS", btnPetugas);
        
        btnUser.setCardName("USER");
        btnUser.setIconType(VectorIcon.Type.USER);
        btnUser.addActionListener(e -> showCard("USER"));
        navButtons.put("USER", btnUser);
        
        btnLaporan.setCardName("LAPORAN");
        btnLaporan.setIconType(VectorIcon.Type.LAPORAN);
        btnLaporan.addActionListener(e -> showCard("LAPORAN"));
        navButtons.put("LAPORAN", btnLaporan);
        
        btnLogout.setCardName("LOGOUT");
        btnLogout.setIconType(VectorIcon.Type.LOGOUT);
        btnLogout.addActionListener(e -> ViewRouter.logout(this));
        
        // Highlight menu aktif
        setActiveNavVisual("MASUK");
    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menuMasterData = new JMenu("Master Data");
        JMenuItem itemKendaraan = new JMenuItem("Kendaraan");
        itemKendaraan.addActionListener(e -> showCard("KENDARAAN"));
        JMenuItem itemTarif = new JMenuItem("Tarif Parkir");
        itemTarif.addActionListener(e -> showCard("TARIF"));
        JMenuItem itemPetugas = new JMenuItem("Petugas");
        itemPetugas.addActionListener(e -> showCard("PETUGAS"));
        JMenuItem itemUser = new JMenuItem("User");
        itemUser.addActionListener(e -> showCard("USER"));
        menuMasterData.add(itemKendaraan);
        menuMasterData.add(itemTarif);
        menuMasterData.add(itemPetugas);
        menuMasterData.add(itemUser);

        JMenu menuTransaksi = new JMenu("Transaksi");
        JMenuItem itemMasuk = new JMenuItem("Parkir Masuk");
        itemMasuk.addActionListener(e -> showCard("MASUK"));
        JMenuItem itemKeluar = new JMenuItem("Parkir Keluar");
        itemKeluar.addActionListener(e -> showCard("KELUAR"));
        menuTransaksi.add(itemMasuk);
        menuTransaksi.add(itemKeluar);

        menuLaporan = new JMenu("Laporan");
        JMenuItem itemLap = new JMenuItem("Laporan Transaksi");
        itemLap.addActionListener(e -> showCard("LAPORAN"));
        menuLaporan.add(itemLap);

        JMenu menuSistem = new JMenu("Sistem");
        menuLogout = new JMenuItem("Logout");
        menuLogout.addActionListener(e -> ViewRouter.logout(this));
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));
        menuSistem.add(menuLogout);
        menuSistem.addSeparator();
        menuSistem.add(itemExit);

        menuBar.add(menuMasterData);
        menuBar.add(menuTransaksi);
        menuBar.add(menuLaporan);
        menuBar.add(menuSistem);

        setJMenuBar(menuBar);
    }

    private void setupAccessControl() {
        String role = SessionManager.getCurrentRole();
        if ("OPERATOR".equalsIgnoreCase(role)) {
            btnKendaraan.setVisible(false);
            btnTarif.setVisible(false);
            btnPetugas.setVisible(false);
            btnUser.setVisible(false);
            btnLaporan.setVisible(false);
            
            menuMasterData.setVisible(false);
            menuLaporan.setVisible(false);
        }
        headerPanel.updateUserInfo();
    }

    public void showCard(String cardName) {
        ViewRouter.showView(cardName, this);
    }

    private void setActiveNavVisual(String activeCard) {
        for (Map.Entry<String, NavButton> entry : navButtons.entrySet()) {
            NavButton btn = entry.getValue();
            btn.setActive(entry.getKey().equals(activeCard));
        }
    }

    public TransaksiMasukPanel getTransaksiMasukPanel() {
        return transaksiMasukPanel;
    }

    public void addLogoutListener(ActionListener l) {
        btnLogout.addActionListener(l);
        if (menuLogout != null) {
            menuLogout.addActionListener(l);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerPanel = new com.mycompany.tugasakhir.view.component.HeaderPanel();
        sidebarPanel = new javax.swing.JPanel();
        lblAppTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDashboard = new com.mycompany.tugasakhir.view.component.NavButton();
        btnMasuk = new com.mycompany.tugasakhir.view.component.NavButton();
        btnKeluar = new com.mycompany.tugasakhir.view.component.NavButton();
        btnKendaraan = new com.mycompany.tugasakhir.view.component.NavButton();
        btnTarif = new com.mycompany.tugasakhir.view.component.NavButton();
        btnPetugas = new com.mycompany.tugasakhir.view.component.NavButton();
        btnUser = new com.mycompany.tugasakhir.view.component.NavButton();
        btnLaporan = new com.mycompany.tugasakhir.view.component.NavButton();
        boxSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        btnLogout = new com.mycompany.tugasakhir.view.component.NavButton();
        contentArea = new javax.swing.JPanel();
        transaksiMasukPanel = new com.mycompany.tugasakhir.view.panel.TransaksiMasukPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Parkir Masuk");
        setMinimumSize(new java.awt.Dimension(1150, 700));
        getContentPane().add(headerPanel, java.awt.BorderLayout.NORTH);

        sidebarPanel.setBackground(new java.awt.Color(26, 26, 46));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(240, 0));
        sidebarPanel.setLayout(new java.awt.GridBagLayout());

        lblAppTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblAppTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblAppTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppTitle.setText(" PARKIRKU");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        sidebarPanel.add(lblAppTitle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(jSeparator1, gridBagConstraints);

        btnDashboard.setText("Dashboard");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnDashboard, gridBagConstraints);

        btnMasuk.setText("Parkir Masuk");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnMasuk, gridBagConstraints);

        btnKeluar.setText("Parkir Keluar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnKeluar, gridBagConstraints);

        btnKendaraan.setText("Kelola Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnKendaraan, gridBagConstraints);

        btnTarif.setText("Kelola Tarif");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnTarif, gridBagConstraints);

        btnPetugas.setText("Kelola Petugas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnPetugas, gridBagConstraints);

        btnUser.setText("Kelola User");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnUser, gridBagConstraints);

        btnLaporan.setText("Laporan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnLaporan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        sidebarPanel.add(boxSpacer, gridBagConstraints);

        btnLogout.setBackground(new java.awt.Color(233, 69, 96));
        btnLogout.setText("Keluar (Logout)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 20, 0);
        sidebarPanel.add(btnLogout, gridBagConstraints);

        getContentPane().add(sidebarPanel, java.awt.BorderLayout.WEST);

        contentArea.setBackground(new java.awt.Color(240, 242, 245));
        contentArea.setLayout(new java.awt.CardLayout());
        contentArea.add(transaksiMasukPanel, "MASUK");

        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler boxSpacer;
    private com.mycompany.tugasakhir.view.component.NavButton btnDashboard;
    private com.mycompany.tugasakhir.view.component.NavButton btnKeluar;
    private com.mycompany.tugasakhir.view.component.NavButton btnKendaraan;
    private com.mycompany.tugasakhir.view.component.NavButton btnLaporan;
    private com.mycompany.tugasakhir.view.component.NavButton btnLogout;
    private com.mycompany.tugasakhir.view.component.NavButton btnMasuk;
    private com.mycompany.tugasakhir.view.component.NavButton btnPetugas;
    private com.mycompany.tugasakhir.view.component.NavButton btnTarif;
    private com.mycompany.tugasakhir.view.component.NavButton btnUser;
    private javax.swing.JPanel contentArea;
    private com.mycompany.tugasakhir.view.component.HeaderPanel headerPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JPanel sidebarPanel;
    private com.mycompany.tugasakhir.view.panel.TransaksiMasukPanel transaksiMasukPanel;
    // End of variables declaration//GEN-END:variables
}
