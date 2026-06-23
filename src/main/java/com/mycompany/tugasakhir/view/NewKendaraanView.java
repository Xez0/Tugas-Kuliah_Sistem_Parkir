package com.mycompany.tugasakhir.view;

import com.mycompany.tugasakhir.util.SessionManager;
import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * JFrame Form untuk NewKendaraanView.
 */
public class NewKendaraanView extends javax.swing.JFrame {

    private final Map<String, JButton> navButtons = new HashMap<>();
    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;
    
    private DefaultTableModel tableModel;
    
    // Delegation methods for CRUD views
    public void addSaveListener(ActionListener l) { btnSave.addActionListener(l); }
    public void addDeleteListener(ActionListener l) { btnDelete.addActionListener(l); }
    public void addResetListener(ActionListener l) { btnReset.addActionListener(l); }
    public void addSearchListener(ActionListener l) {
        btnSearch.addActionListener(l);
        txtSearch.addActionListener(l);
    }
    
    public String getIdInput() { return txtId.getText(); }
    public String getJenisInput() { return txtJenis.getText().trim(); }
    public String getTarifAwalInput() { return txtTarifAwal.getText().trim(); }
    public String getTarifPerJamInput() { return txtTarifPerJam.getText().trim(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    public JTextField getTxtJenis() { return txtJenis; }
    public JTextField getTxtTarifAwal() { return txtTarifAwal; }
    public JTextField getTxtTarifPerJam() { return txtTarifPerJam; }

    public void resetForm() {
        txtId.setText("");
        txtJenis.setText("");
        txtTarifAwal.setText("");
        txtTarifPerJam.setText("");
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblData.clearSelection();
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtJenis.setText(tableModel.getValueAt(row, 1).toString());
        String cleanTarifAwal = tableModel.getValueAt(row, 2).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").replace(",-", "").trim();
        String cleanTarifPerJam = tableModel.getValueAt(row, 3).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").replace(",-", "").trim();
        txtTarifAwal.setText(cleanTarifAwal);
        txtTarifPerJam.setText(cleanTarifPerJam);
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        btnDelete.setEnabled(true);
    }

    public void populateTable(java.util.List<com.mycompany.tugasakhir.model.Kendaraan> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.Kendaraan k : list) {
            tableModel.addRow(new Object[]{
                    k.getIdKendaraan(),
                    k.getJenisKendaraan(),
                    com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(k.getTarifAwal()),
                    com.mycompany.tugasakhir.util.CurrencyUtil.formatRupiah(k.getTarifPerJam()),
                    k.getStatus().toString()
            });
        }
    }

    

    public NewKendaraanView() {
        initComponents();
        setupAccessControl();
        initNavButtonStyles();
        setActiveNavVisual("KENDARAAN");
        buildMenuBar();
        customInit();
        
        setMinimumSize(new Dimension(1150, 700));
        setSize(1200, 750);
        setLocationRelativeTo(null);
    }

    private void customInit() {
        java.awt.GridBagConstraints gridBagConstraints;
        
        tableModel = (DefaultTableModel) tblData.getModel();
        com.mycompany.tugasakhir.util.TableUtil.styleTable(tblData);
        
        // Color setup
        btnSave.setBackground(new Color(0, 184, 148));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSave.setIcon(new VectorIcon(VectorIcon.Type.SAVE, 14, Color.WHITE));
        
        btnDelete.setBackground(new Color(214, 48, 49));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnDelete.setIcon(new VectorIcon(VectorIcon.Type.DELETE, 14, Color.WHITE));
        
        btnReset.setBackground(new Color(99, 110, 115));
        btnReset.setForeground(Color.WHITE);
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnReset.setIcon(new VectorIcon(VectorIcon.Type.RESET, 14, Color.WHITE));
        
        btnSearch.setBackground(new Color(15, 52, 96));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSearch.setIcon(new VectorIcon(VectorIcon.Type.SEARCH, 14, Color.WHITE));

        // Click selection and styling details
        
        // Column alignment
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblData.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblData.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblData.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblData.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });
        
        // Populate combo box
        cbStatus.removeAllItems();
        cbStatus.addItem("AKTIF");
        cbStatus.addItem("NONAKTIF");
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
        titlePanel = new javax.swing.JPanel();
        lblContentTitle = new javax.swing.JLabel();
        mainSplitPanel = new javax.swing.JPanel();
        formCard = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblJenis = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        lblTarifAwal = new javax.swing.JLabel();
        txtTarifAwal = new javax.swing.JTextField();
        lblTarifPerJam = new javax.swing.JLabel();
        txtTarifPerJam = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        formSpacer = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        buttonPanel = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        tableCard = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kelola Jenis Kendaraan & Tarif Awal");
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
        btnKendaraan.addActionListener(this::btnKendaraanActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnKendaraan, gridBagConstraints);

        btnPetugas.setText("Kelola Petugas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        sidebarPanel.add(btnPetugas, gridBagConstraints);

        btnUser.setText("Kelola User");
        btnUser.addActionListener(this::btnUserActionPerformed);
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 1.0;
        sidebarPanel.add(boxSpacer, gridBagConstraints);

        btnLogout.setBackground(new java.awt.Color(233, 69, 96));
        btnLogout.setText("Keluar (Logout)");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
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

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(0, 40));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lblContentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblContentTitle.setText("Kelola Jenis Kendaraan & Tarif Awal");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.BorderLayout(15, 15));

        formCard.setBackground(new java.awt.Color(255, 255, 255));
        formCard.setPreferredSize(new java.awt.Dimension(320, 0));
        formCard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        formCard.setLayout(new java.awt.GridBagLayout());

        lblId.setText("ID Kendaraan (Otomatis)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblId, gridBagConstraints);

        txtId.setEnabled(false);
        txtId.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtId, gridBagConstraints);

        lblJenis.setText("Jenis Kendaraan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblJenis, gridBagConstraints);

        txtJenis.setPreferredSize(new java.awt.Dimension(0, 35));
        txtJenis.addActionListener(this::txtJenisActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtJenis, gridBagConstraints);

        lblTarifAwal.setText("Tarif Awal (Rp)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblTarifAwal, gridBagConstraints);

        txtTarifAwal.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtTarifAwal, gridBagConstraints);

        lblTarifPerJam.setText("Tarif Per Jam (Rp)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblTarifPerJam, gridBagConstraints);

        txtTarifPerJam.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(txtTarifPerJam, gridBagConstraints);

        lblStatus.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        formCard.add(lblStatus, gridBagConstraints);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "" }));
        cbStatus.setPreferredSize(new java.awt.Dimension(0, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        formCard.add(cbStatus, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formCard.add(formSpacer, gridBagConstraints);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btnSave.setText("SIMPAN");
        buttonPanel.add(btnSave);

        btnDelete.setText("HAPUS");
        buttonPanel.add(btnDelete);

        btnReset.setText("BATAL");
        buttonPanel.add(btnReset);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        formCard.add(buttonPanel, gridBagConstraints);

        mainSplitPanel.add(formCard, java.awt.BorderLayout.WEST);

        tableCard.setBackground(new java.awt.Color(255, 255, 255));
        tableCard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tableCard.setLayout(new java.awt.BorderLayout(10, 10));

        searchPanel.setOpaque(false);
        searchPanel.setLayout(new java.awt.BorderLayout(5, 5));

        txtSearch.setPreferredSize(new java.awt.Dimension(200, 36));
        searchPanel.add(txtSearch);

        btnSearch.setText("CARI");
        btnSearch.setPreferredSize(new java.awt.Dimension(95, 36));
        searchPanel.add(btnSearch, java.awt.BorderLayout.EAST);

        tableCard.add(searchPanel, java.awt.BorderLayout.NORTH);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Jenis Kendaraan", "Tarif Awal", "Tarif Per Jam", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblData);

        tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        mainSplitPanel.add(tableCard, java.awt.BorderLayout.CENTER);

        contentArea.add(mainSplitPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKendaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKendaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKendaraanActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJenisActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserActionPerformed

    private void initCustomFields() {
        java.awt.GridBagConstraints gridBagConstraints;
        // Dynamic initialization of inputs to hook Swing builder
        
        // Alignment moved to customInit()


        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblData.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });
        
        // Add components to form card
        txtId = new javax.swing.JTextField();
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 35));
        
        txtJenis = new javax.swing.JTextField();
        txtJenis.setPreferredSize(new Dimension(0, 35));
        
        txtTarifAwal = new javax.swing.JTextField();
        txtTarifAwal.setPreferredSize(new Dimension(0, 35));
        
        txtTarifPerJam = new javax.swing.JTextField();
        txtTarifPerJam.setPreferredSize(new Dimension(0, 35));
        
        cbStatus = new javax.swing.JComboBox<>(new String[]{"AKTIF", "NONAKTIF"});
        cbStatus.setPreferredSize(new Dimension(0, 35));

        // Layout setup
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5,0,5,0);
        formCard.add(new javax.swing.JLabel("ID Kendaraan (Otomatis)"), gridBagConstraints);

        gridBagConstraints.gridy = 1;
        formCard.add(txtId, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        formCard.add(new javax.swing.JLabel("Jenis Kendaraan"), gridBagConstraints);

        gridBagConstraints.gridy = 3;
        formCard.add(txtJenis, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        formCard.add(new javax.swing.JLabel("Tarif Awal (Rp)"), gridBagConstraints);

        gridBagConstraints.gridy = 5;
        formCard.add(txtTarifAwal, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        formCard.add(new javax.swing.JLabel("Tarif Per Jam (Rp)"), gridBagConstraints);

        gridBagConstraints.gridy = 7;
        formCard.add(txtTarifPerJam, gridBagConstraints);

        gridBagConstraints.gridy = 8;
        formCard.add(new javax.swing.JLabel("Status"), gridBagConstraints);

        gridBagConstraints.gridy = 9;
        formCard.add(cbStatus, gridBagConstraints);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler boxSpacer;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKendaraan;
    private javax.swing.JButton btnLaporan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMasuk;
    private javax.swing.JButton btnPetugas;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUser;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JPanel contentArea;
    private javax.swing.JPanel formCard;
    private javax.swing.Box.Filler formSpacer;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel headerRightPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblContentTitle;
    private javax.swing.JLabel lblHeaderTitle;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTarifAwal;
    private javax.swing.JLabel lblTarifPerJam;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel tableCard;
    private javax.swing.JTable tblData;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTarifAwal;
    private javax.swing.JTextField txtTarifPerJam;
    // End of variables declaration//GEN-END:variables
    
}
