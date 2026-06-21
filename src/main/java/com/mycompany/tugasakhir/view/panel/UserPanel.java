package com.mycompany.tugasakhir.view.panel;

import com.mycompany.tugasakhir.model.User;
import com.mycompany.tugasakhir.util.TableUtil;
import com.mycompany.tugasakhir.view.component.RoundedButton;
import com.mycompany.tugasakhir.view.component.RoundedPasswordField;
import com.mycompany.tugasakhir.view.component.RoundedTextField;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Panel CRUD Data User.
 * Layout Side-by-Side: Form di kiri, Tabel di kanan.
 */
public class UserPanel extends JPanel {

    private RoundedTextField txtId;
    private RoundedTextField txtNama;
    private RoundedTextField txtUsername;
    private RoundedPasswordField txtPassword;
    private JComboBox<String> cbRole;
    private JComboBox<String> cbStatus;

    private RoundedButton btnSave;
    private RoundedButton btnDelete;
    private RoundedButton btnReset;

    private RoundedTextField txtSearch;
    private RoundedButton btnSearch;
    private JTable tblUser;
    private DefaultTableModel tableModel;

    public UserPanel() {
        initComponents();
        resetForm();
    }

    private void initComponents() {
        setLayout(new BorderLayout(15, 15));
        setBackground(new Color(240, 242, 245));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title Panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setOpaque(false);
        JLabel lblTitle = new JLabel("Kelola Akun User Sistem");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(26, 26, 46));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.NORTH);

        // Split Layout (Left: Form, Right: Table)
        JPanel contentPanel = new JPanel(new BorderLayout(15, 15));
        contentPanel.setOpaque(false);

        // ==========================================
        // FORM PANEL (LEFT)
        // ==========================================
        JPanel formCard = new JPanel(new GridBagLayout());
        formCard.setBackground(Color.WHITE);
        formCard.setPreferredSize(new Dimension(340, getPreferredSize().height));
        formCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Label ID
        formCard.add(new JLabel("ID User (Otomatis)"), gbc);
        gbc.gridy++;
        txtId = new RoundedTextField(10);
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtId, gbc);

        // Label Nama
        gbc.gridy++;
        formCard.add(new JLabel("Nama Lengkap"), gbc);
        gbc.gridy++;
        txtNama = new RoundedTextField(20);
        txtNama.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtNama, gbc);

        // Label Username
        gbc.gridy++;
        formCard.add(new JLabel("Username"), gbc);
        gbc.gridy++;
        txtUsername = new RoundedTextField(20);
        txtUsername.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtUsername, gbc);

        // Label Password
        gbc.gridy++;
        formCard.add(new JLabel("Password (Kosongkan jika tidak diubah)"), gbc);
        gbc.gridy++;
        txtPassword = new RoundedPasswordField(20);
        txtPassword.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtPassword, gbc);

        // Label Role
        gbc.gridy++;
        formCard.add(new JLabel("Role"), gbc);
        gbc.gridy++;
        cbRole = new JComboBox<>(new String[]{"OPERATOR", "ADMIN"});
        cbRole.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbRole.setPreferredSize(new Dimension(0, 35));
        formCard.add(cbRole, gbc);

        // Label Status
        gbc.gridy++;
        formCard.add(new JLabel("Status"), gbc);
        gbc.gridy++;
        cbStatus = new JComboBox<>(new String[]{"AKTIF", "NONAKTIF"});
        cbStatus.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cbStatus.setPreferredSize(new Dimension(0, 35));
        formCard.add(cbStatus, gbc);

        // Spacer
        gbc.gridy++;
        gbc.weighty = 1.0;
        formCard.add(Box.createVerticalGlue(), gbc);

        // Buttons
        gbc.gridy++;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(15, 0, 5, 0);
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        buttonPanel.setOpaque(false);

        btnSave = new RoundedButton("SIMPAN", new Color(0, 184, 148), 8);
        btnSave.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SAVE, 14, Color.WHITE));
        btnSave.setIconTextGap(5);

        btnDelete = new RoundedButton("HAPUS", new Color(214, 48, 49), 8);
        btnDelete.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.DELETE, 14, Color.WHITE));
        btnDelete.setIconTextGap(5);

        btnReset = new RoundedButton("BATAL", new Color(99, 110, 115), 8);
        btnReset.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.RESET, 14, Color.WHITE));
        btnReset.setIconTextGap(5);

        buttonPanel.add(btnSave);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnReset);
        formCard.add(buttonPanel, gbc);

        contentPanel.add(formCard, BorderLayout.WEST);

        // ==========================================
        // TABLE PANEL (RIGHT)
        // ==========================================
        JPanel tableCard = new JPanel(new BorderLayout(10, 10));
        tableCard.setBackground(Color.WHITE);
        tableCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Search Panel
        JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
        searchPanel.setOpaque(false);
        txtSearch = new RoundedTextField(20);
        txtSearch.setPreferredSize(new Dimension(200, 36));
        btnSearch = new RoundedButton("CARI", new Color(15, 52, 96), 8);
        btnSearch.setIcon(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.SEARCH, 14, Color.WHITE));
        btnSearch.setIconTextGap(5);
        btnSearch.setPreferredSize(new Dimension(95, 36));
        
        searchPanel.add(txtSearch, BorderLayout.CENTER);
        searchPanel.add(btnSearch, BorderLayout.EAST);
        tableCard.add(searchPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {"ID", "Nama Lengkap", "Username", "Role", "Status"};
        tableModel = TableUtil.createReadOnlyModel(columns);
        tblUser = new JTable(tableModel);
        TableUtil.styleTable(tblUser);

        // Center alignments
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblUser.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblUser.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblUser.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        tableCard.add(TableUtil.wrapInScrollPane(tblUser), BorderLayout.CENTER);
        contentPanel.add(tableCard, BorderLayout.CENTER);

        add(contentPanel, BorderLayout.CENTER);

        // Table Click Selection
        tblUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblUser.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtNama.setText(tableModel.getValueAt(row, 1).toString());
        txtUsername.setText(tableModel.getValueAt(row, 2).toString());
        txtPassword.setText(""); // Reset password on select (keep blank for no change)
        cbRole.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        
        btnDelete.setEnabled(true);
    }

    public void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cbRole.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblUser.clearSelection();
    }

    // Form inputs getters
    public String getIdInput() { return txtId.getText(); }
    public String getNamaInput() { return txtNama.getText().trim(); }
    public String getUsernameInput() { return txtUsername.getText().trim(); }
    public String getPasswordInput() { return new String(txtPassword.getPassword()); }
    public String getRoleInput() { return cbRole.getSelectedItem().toString(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    // Actions
    public void addSaveListener(ActionListener l) { btnSave.addActionListener(l); }
    public void addDeleteListener(ActionListener l) { btnDelete.addActionListener(l); }
    public void addResetListener(ActionListener l) { btnReset.addActionListener(l); }
    public void addSearchListener(ActionListener l) {
        btnSearch.addActionListener(l);
        txtSearch.addActionListener(l);
    }

    // Populate Table
    public void populateTable(List<User> list) {
        TableUtil.clearTable(tableModel);
        for (User u : list) {
            tableModel.addRow(new Object[]{
                    u.getIdUser(),
                    u.getNama(),
                    u.getUsername(),
                    u.getRole().toString(),
                    u.getStatus().toString()
            });
        }
    }
}
