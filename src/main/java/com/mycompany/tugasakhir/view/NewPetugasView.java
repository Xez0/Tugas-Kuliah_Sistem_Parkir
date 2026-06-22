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
 * JFrame Form untuk NewPetugasView.
 */
public class NewPetugasView extends javax.swing.JFrame {

    private final Map<String, JButton> navButtons = new HashMap<>();
    private JMenuItem menuLogout;
    private JMenu menuMasterData;
    private JMenu menuLaporan;
    
    private DefaultTableModel tableModel;
    
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JTextField txtNoTelp;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel lblPasswordHint;

    
    // Delegation methods for CRUD views
    public void addSaveListener(ActionListener l) { btnSave.addActionListener(l); }
    public void addDeleteListener(ActionListener l) { btnDelete.addActionListener(l); }
    public void addResetListener(ActionListener l) { btnReset.addActionListener(l); }
    public void addSearchListener(ActionListener l) {
        btnSearch.addActionListener(l);
        txtSearch.addActionListener(l);
    }
    
    public String getIdInput() { return txtId.getText(); }
    public String getNamaInput() { return txtNama.getText().trim(); }
    public String getUsernameInput() { return txtUsername.getText().trim(); }
    public String getPasswordInput() { return new String(txtPassword.getPassword()); }
    public String getRoleInput() { return cbRole.getSelectedItem().toString(); }
    public String getNoTelpInput() { return txtNoTelp.getText().trim(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    public void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cbRole.setSelectedIndex(0);
        txtNoTelp.setText("");
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblData.clearSelection();
        if (lblPasswordHint != null) {
            lblPasswordHint.setText("Password");
        }
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtNama.setText(tableModel.getValueAt(row, 1).toString());
        txtUsername.setText(tableModel.getValueAt(row, 2).toString());
        txtPassword.setText("");
        cbRole.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        txtNoTelp.setText(tableModel.getValueAt(row, 4) != null ? tableModel.getValueAt(row, 4).toString() : "");
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 5).toString());
        btnDelete.setEnabled(true);
        if (lblPasswordHint != null) {
            lblPasswordHint.setText("Password (Kosongkan jika tidak diubah)");
        }
    }

    public void populateTable(java.util.List<com.mycompany.tugasakhir.model.Petugas> list) {
        com.mycompany.tugasakhir.util.TableUtil.clearTable(tableModel);
        for (com.mycompany.tugasakhir.model.Petugas p : list) {
            tableModel.addRow(new Object[]{
                    p.getIdPetugas(),
                    p.getNama(),
                    p.getUsername(),
                    p.getRole().toString(),
                    p.getNoTelp(),
                    p.getStatus().toString()
            });
        }
    }

    

    public NewPetugasView() {
        initComponents();
        setupAccessControl();
        initNavButtonStyles();
        setActiveNavVisual("PETUGAS");
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
        tblData.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblData.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

        tblData.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblData.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });

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
        setTitle("Kelola Data Petugas Parkir");
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

        titlePanel.setOpaque(false);
        titlePanel.setPreferredSize(new java.awt.Dimension(0, 40));
        titlePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        lblContentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblContentTitle.setForeground(new java.awt.Color(26, 26, 46));
        lblContentTitle.setText("Kelola Data Petugas Parkir");
        titlePanel.add(lblContentTitle);

        contentArea.add(titlePanel, java.awt.BorderLayout.NORTH);

        mainSplitPanel.setOpaque(false);
        mainSplitPanel.setLayout(new java.awt.BorderLayout(15, 15));

        formCard.setBackground(new java.awt.Color(255, 255, 255));
        formCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        formCard.setPreferredSize(new java.awt.Dimension(340, 0));
        formCard.setLayout(new java.awt.GridBagLayout());

        // Field specific initializations will run programmatically
        initCustomFields();

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 5, 0);
        formCard.add(buttonPanel, gridBagConstraints);

        mainSplitPanel.add(formCard, java.awt.BorderLayout.WEST);

        tableCard.setBackground(new java.awt.Color(255, 255, 255));
        tableCard.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)), javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        tableCard.setLayout(new java.awt.BorderLayout(10, 10));

        searchPanel.setOpaque(false);
        searchPanel.setLayout(new java.awt.BorderLayout(5, 5));
        searchPanel.add(txtSearch, java.awt.BorderLayout.CENTER);

        btnSearch.setText("CARI");
        btnSearch.setPreferredSize(new java.awt.Dimension(95, 36));
        searchPanel.add(btnSearch, java.awt.BorderLayout.EAST);

        tableCard.add(searchPanel, java.awt.BorderLayout.NORTH);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nama Lengkap", "Username", "Role", "No. Telp", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        txtId = new javax.swing.JTextField();
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 32));
        
        txtNama = new javax.swing.JTextField();
        txtNama.setPreferredSize(new Dimension(0, 32));
        
        txtUsername = new javax.swing.JTextField();
        txtUsername.setPreferredSize(new Dimension(0, 32));
        
        txtPassword = new javax.swing.JPasswordField();
        txtPassword.setPreferredSize(new Dimension(0, 32));
        
        cbRole = new javax.swing.JComboBox<>(new String[]{"OPERATOR", "ADMIN"});
        cbRole.setPreferredSize(new Dimension(0, 32));
        
        txtNoTelp = new javax.swing.JTextField();
        txtNoTelp.setPreferredSize(new Dimension(0, 32));
        
        cbStatus = new javax.swing.JComboBox<>(new String[]{"AKTIF", "NONAKTIF"});
        cbStatus.setPreferredSize(new Dimension(0, 32));

        lblPasswordHint = new javax.swing.JLabel("Password");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4,0,4,0);
        formCard.add(new javax.swing.JLabel("ID Petugas (Otomatis)"), gridBagConstraints);

        gridBagConstraints.gridy = 1;
        formCard.add(txtId, gridBagConstraints);

        gridBagConstraints.gridy = 2;
        formCard.add(new javax.swing.JLabel("Nama Lengkap"), gridBagConstraints);

        gridBagConstraints.gridy = 3;
        formCard.add(txtNama, gridBagConstraints);

        gridBagConstraints.gridy = 4;
        formCard.add(new javax.swing.JLabel("Username"), gridBagConstraints);

        gridBagConstraints.gridy = 5;
        formCard.add(txtUsername, gridBagConstraints);

        gridBagConstraints.gridy = 6;
        formCard.add(lblPasswordHint, gridBagConstraints);

        gridBagConstraints.gridy = 7;
        formCard.add(txtPassword, gridBagConstraints);

        gridBagConstraints.gridy = 8;
        formCard.add(new javax.swing.JLabel("Role"), gridBagConstraints);

        gridBagConstraints.gridy = 9;
        formCard.add(cbRole, gridBagConstraints);

        gridBagConstraints.gridy = 10;
        formCard.add(new javax.swing.JLabel("No. Telepon"), gridBagConstraints);

        gridBagConstraints.gridy = 11;
        formCard.add(txtNoTelp, gridBagConstraints);

        gridBagConstraints.gridy = 12;
        formCard.add(new javax.swing.JLabel("Status"), gridBagConstraints);

        gridBagConstraints.gridy = 13;
        formCard.add(cbStatus, gridBagConstraints);

    }

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
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel sidebarPanel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel mainSplitPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel tableCard;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
    
}
