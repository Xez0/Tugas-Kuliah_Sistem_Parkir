package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


/**
 * JFrame Form untuk NewTransaksiMasukView.
 */
public class NewTransaksiMasukView extends javax.swing.JFrame {

    private final Map<String, JButton> navButtons = new HashMap<>();
    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;
    
    private DefaultTableModel tableModel;

    // Form elements declared visually in form
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblPlatLabel;
    private javax.swing.JTextField txtPlatNomor;
    private javax.swing.JLabel lblJenisLabel;
    private javax.swing.JComboBox<com.mycompany.tugasakhir.model.Kendaraan> cbJenisKendaraan;
    private javax.swing.JLabel lblPetugasLabel;
    private javax.swing.JComboBox<com.mycompany.tugasakhir.model.Petugas> cbPetugasMasuk;
    private javax.swing.Box.Filler formSpacer;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel formCard;
    private javax.swing.JPanel tableCard;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblActiveParking;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel lblContentTitle;

    // Public Controller delegation methods
    public void setJenisKendaraanList(java.util.List<com.mycompany.tugasakhir.model.Kendaraan> list) {
        cbJenisKendaraan.removeAllItems();
        for (com.mycompany.tugasakhir.model.Kendaraan k : list) {
            cbJenisKendaraan.addItem(k);
        }
    }

    public void setPetugasList(java.util.List<com.mycompany.tugasakhir.model.Petugas> list) {
        cbPetugasMasuk.removeAllItems();
        for (com.mycompany.tugasakhir.model.Petugas p : list) {
            cbPetugasMasuk.addItem(p);
        }
    }

    public void resetForm() {
        txtPlatNomor.setText("");
        if (cbJenisKendaraan.getItemCount() > 0) {
            cbJenisKendaraan.setSelectedIndex(0);
        }
        txtPlatNomor.requestFocus();
    }

    public String getPlatNomorInput() {
        return txtPlatNomor.getText().trim().toUpperCase();
    }

    public com.mycompany.tugasakhir.model.Kendaraan getSelectedKendaraan() {
        return (com.mycompany.tugasakhir.model.Kendaraan) cbJenisKendaraan.getSelectedItem();
    }

    public com.mycompany.tugasakhir.model.Petugas getSelectedPetugas() {
        return (com.mycompany.tugasakhir.model.Petugas) cbPetugasMasuk.getSelectedItem();
    }

    public JTextField getTxtPlatNomor() { return txtPlatNomor; }
    public JComboBox<com.mycompany.tugasakhir.model.Kendaraan> getCbJenisKendaraan() { return cbJenisKendaraan; }
    public JButton getBtnProses() { return btnProses; }

    public void addProsesListener(ActionListener l) {
        btnProses.addActionListener(l);
        txtPlatNomor.addActionListener(l); // Trigger on enter key
    }

    public void addResetListener(ActionListener l) {
        btnReset.addActionListener(l);
    }

    public void populateActiveParkingTable(java.util.List<com.mycompany.tugasakhir.model.TransaksiParkir> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.TransaksiParkir t : list) {
            String formatMasuk = t.getJamMasuk() != null ? t.getJamMasuk().toString() : "-";
            tableModel.addRow(new Object[]{
                    t.getIdTransaksi(),
                    t.getPlatNomor(),
                    t.getJenisKendaraan(),
                    formatMasuk,
                    t.getNamaPetugasMasuk()
            });
        }
    }


    public NewTransaksiMasukView() {
        initComponents();
        setupAccessControl();
        initNavButtonStyles();
        setActiveNavVisual("MASUK");
        buildMenuBar();
        customInit();
        
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
    }

    private void customInit() {
        
        tableModel = (DefaultTableModel) tblActiveParking.getModel();
        com.mycompany.tugasakhir.util.TableUtil.styleTable(tblActiveParking);
        
        // Alignments
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblActiveParking.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblActiveParking.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        // Styling elements
        btnProses.setBackground(new Color(0, 184, 148));
        btnProses.setForeground(Color.WHITE);
        btnProses.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnProses.setIcon(new VectorIcon(VectorIcon.Type.SAVE, 16, Color.WHITE));
        
        btnReset.setBackground(new Color(99, 110, 115));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnReset.setIcon(new VectorIcon(VectorIcon.Type.RESET, 16, Color.WHITE));

    }

    private void initNavButtonStyles() {
        JButton[] buttons = {btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnPetugas, btnUser, btnLaporan, btnLogout};
        Color defaultBg = new Color(26, 26, 46);
        Color defaultFg = new Color(200, 200, 200);
        
        for (JButton btn : buttons) {
            btn.setBackground(defaultBg);
            btn.setForeground(defaultFg);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(true);
            btn.setOpaque(true);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        
        btnLogout.setBackground(new Color(233, 69, 96));
        btnLogout.setForeground(Color.WHITE);
    }

    private void setActiveNavVisual(String activeCard) {
        Color defaultBg = new Color(26, 26, 46);
        Color defaultFg = new Color(200, 200, 200);
        Color activeBg = new Color(15, 52, 96);
        Color activeFg = Color.WHITE;
        
        JButton[] buttons = {btnDashboard, btnMasuk, btnKeluar, btnKendaraan, btnPetugas, btnUser, btnLaporan};
        String[] cards = {"DASHBOARD", "MASUK", "KELUAR", "KENDARAAN", "PETUGAS", "USER", "LAPORAN"};
        
        for (int i = 0; i < buttons.length; i++) {
            if (cards[i].equals(activeCard)) {
                buttons[i].setBackground(activeBg);
                buttons[i].setForeground(activeFg);
                buttons[i].setIcon(new VectorIcon(VectorIcon.Type.valueOf(cards[i]), 18, activeFg));
            } else {
                buttons[i].setBackground(defaultBg);
                buttons[i].setForeground(defaultFg);
                buttons[i].setIcon(new VectorIcon(VectorIcon.Type.valueOf(cards[i]), 18, defaultFg));
            }
        }
        btnLogout.setIcon(new VectorIcon(VectorIcon.Type.LOGOUT, 18, Color.WHITE));
        
        btnDashboard.addActionListener(e -> showCard("DASHBOARD"));
        btnMasuk.addActionListener(e -> showCard("MASUK"));
        btnKeluar.addActionListener(e -> showCard("KELUAR"));
        btnKendaraan.addActionListener(e -> showCard("KENDARAAN"));
        btnPetugas.addActionListener(e -> showCard("PETUGAS"));
        btnUser.addActionListener(e -> showCard("USER"));
        btnLaporan.addActionListener(e -> showCard("LAPORAN"));
        btnLogout.addActionListener(e -> ViewRouter.logout(this));
    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuMasterData = new JMenu("Master Data");
        JMenuItem itemKendaraan = new JMenuItem("Kendaraan");
        itemKendaraan.addActionListener(e -> showCard("KENDARAAN"));JMenuItem itemPetugas = new JMenuItem("Petugas");
        itemPetugas.addActionListener(e -> showCard("PETUGAS"));
        JMenuItem itemUser = new JMenuItem("User");
        itemUser.addActionListener(e -> showCard("USER"));
        menuMasterData.add(itemKendaraan);menuMasterData.add(itemPetugas);
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
            btnPetugas.setVisible(false);
            btnUser.setVisible(false);
            btnLaporan.setVisible(false);
            menuMasterData.setVisible(false);
            menuLaporan.setVisible(false);
        }
        headerPanel.setBackground(new Color(15, 52, 96));
        lblUser.setText(SessionManager.getCurrentUsername() + " (" + role + ")");
        Timer clockTimer = new Timer(1000, e -> {
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            lblClock.setText(now.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        });
        clockTimer.start();
    }

    public void showCard(String cardName) {
        ViewRouter.showView(cardName, this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        headerPanel = new javax.swing.JPanel();
        lblHeaderTitle = new javax.swing.JLabel();
        headerRightPanel = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        sidebarPanel = new javax.swing.JPanel();
        lblAppTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDashboard = new javax.swing.JButton();
        btnMasuk = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnKendaraan = new javax.swing.JButton();
        btnPetugas = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnLaporan = new javax.swing.JButton();
        boxSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        btnLogout = new javax.swing.JButton();
        contentArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Parkir Desktop - Parkir Masuk");
        setMinimumSize(new java.awt.Dimension(1150, 700));

        headerPanel.setBackground(new java.awt.Color(15, 52, 96));
        headerPanel.setPreferredSize(new java.awt.Dimension(0, 55));
        headerPanel.setLayout(new java.awt.BorderLayout());

        lblHeaderTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblHeaderTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblHeaderTitle.setText("Sistem Parkir Modern");
        lblHeaderTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        headerPanel.add(lblHeaderTitle, java.awt.BorderLayout.WEST);

        headerRightPanel.setOpaque(false);
        headerRightPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 15));

        lblUser.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblUser.setForeground(new java.awt.Color(200, 200, 200));
        lblUser.setText("User (Role)");
        headerRightPanel.add(lblUser);

        lblClock.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblClock.setForeground(new java.awt.Color(200, 200, 200));
        lblClock.setText("Clock");
        headerRightPanel.add(lblClock);

        headerPanel.add(headerRightPanel, java.awt.BorderLayout.EAST);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);

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
        contentArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentArea.setLayout(new java.awt.BorderLayout());

        
        titlePanel = new javax.swing.JPanel();
        lblContentTitle = new javax.swing.JLabel();
        mainSplitPanel = new javax.swing.JPanel();
        formCard = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();
        lblPlatLabel = new javax.swing.JLabel();
        txtPlatNomor = new javax.swing.JTextField();
        lblJenisLabel = new javax.swing.JLabel();
        cbJenisKendaraan = new javax.swing.JComboBox<>();
        formSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        buttonPanel = new javax.swing.JPanel();
        btnProses = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tableCard = new javax.swing.JPanel();
        lblTableTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActiveParking = new javax.swing.JTable();

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(0, 40));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lblContentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblContentTitle.setText("Transaksi Parkir Masuk");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.BorderLayout(15, 15));

        formCard.setBackground(new java.awt.Color(255, 255, 255));
        formCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        formCard.setPreferredSize(new java.awt.Dimension(320, 0));
        formCard.setLayout(new java.awt.GridBagLayout());

        lblBanner.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblBanner.setForeground(new java.awt.Color(15, 52, 96));
        lblBanner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBanner.setText("Entry Parkir Baru");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        formCard.add(lblBanner, gridBagConstraints);

        lblPlatLabel.setText("Plat Nomor Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        formCard.add(lblPlatLabel, gridBagConstraints);

        txtPlatNomor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPlatNomor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPlatNomor.setPreferredSize(new java.awt.Dimension(0, 42));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtPlatNomor, gridBagConstraints);

        lblJenisLabel.setText("Jenis Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        formCard.add(lblJenisLabel, gridBagConstraints);

        cbJenisKendaraan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbJenisKendaraan.setPreferredSize(new java.awt.Dimension(0, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(cbJenisKendaraan, gridBagConstraints);

        lblPetugasLabel = new javax.swing.JLabel();
        lblPetugasLabel.setText("Petugas Masuk");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        formCard.add(lblPetugasLabel, gridBagConstraints);

        cbPetugasMasuk = new javax.swing.JComboBox<>();
        cbPetugasMasuk.setFont(new java.awt.Font("Segoe UI", 0, 14));
        cbPetugasMasuk.setPreferredSize(new java.awt.Dimension(0, 38));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(cbPetugasMasuk, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formCard.add(formSpacer, gridBagConstraints);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(1, 2, 8, 8));

        btnProses.setText("MASUK");
        buttonPanel.add(btnProses);

        btnReset.setText("RESET");
        buttonPanel.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 5, 0);
        formCard.add(buttonPanel, gridBagConstraints);

        mainSplitPanel.add(formCard, java.awt.BorderLayout.WEST);

        tableCard.setBackground(new java.awt.Color(255, 255, 255));
        tableCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        tableCard.setLayout(new java.awt.BorderLayout(10, 10));

        lblTableTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTableTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblTableTitle.setText("Kendaraan yang Sedang Parkir");
        tableCard.add(lblTableTitle, java.awt.BorderLayout.NORTH);

        tblActiveParking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Transaksi", "Plat Nomor", "Jenis", "Jam Masuk", "Petugas Masuk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblActiveParking);

        tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(tableCard, java.awt.BorderLayout.CENTER);

        contentArea.add(mainSplitPanel, java.awt.BorderLayout.CENTER);
    
        
        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler boxSpacer;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKendaraan;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPetugas;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel contentArea;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblHeaderTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel headerRightPanel;
    // End of variables declaration//GEN-END:variables
    
}
