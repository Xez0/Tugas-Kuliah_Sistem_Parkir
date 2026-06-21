package com.mycompany.tugasakhir.view.panel;

import com.mycompany.tugasakhir.model.Kendaraan;
import com.mycompany.tugasakhir.util.CurrencyUtil;
import com.mycompany.tugasakhir.util.TableUtil;
import com.mycompany.tugasakhir.view.component.RoundedButton;
import com.mycompany.tugasakhir.view.component.RoundedTextField;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Panel CRUD Data Kendaraan.
 * Layout Side-by-Side: Form di kiri, Tabel di kanan.
 */
public class KendaraanPanel extends JPanel {

    private RoundedTextField txtId;
    private RoundedTextField txtJenis;
    private RoundedTextField txtTarifAwal;
    private RoundedTextField txtTarifPerJam;
    private JComboBox<String> cbStatus;
    
    private RoundedButton btnSave;
    private RoundedButton btnDelete;
    private RoundedButton btnReset;

    private RoundedTextField txtSearch;
    private RoundedButton btnSearch;
    private JTable tblKendaraan;
    private DefaultTableModel tableModel;

    public KendaraanPanel() {
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
        JLabel lblTitle = new JLabel("Kelola Jenis Kendaraan & Tarif Awal");
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
        formCard.setPreferredSize(new Dimension(320, getPreferredSize().height));
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
        formCard.add(new JLabel("ID Kendaraan (Otomatis)"), gbc);
        gbc.gridy++;
        txtId = new RoundedTextField(10);
        txtId.setEnabled(false);
        txtId.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtId, gbc);

        // Label Jenis
        gbc.gridy++;
        formCard.add(new JLabel("Jenis Kendaraan"), gbc);
        gbc.gridy++;
        txtJenis = new RoundedTextField(20);
        txtJenis.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtJenis, gbc);

        // Label Tarif Awal
        gbc.gridy++;
        formCard.add(new JLabel("Tarif Awal (Rp)"), gbc);
        gbc.gridy++;
        txtTarifAwal = new RoundedTextField(20);
        txtTarifAwal.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtTarifAwal, gbc);

        // Label Tarif Per Jam
        gbc.gridy++;
        formCard.add(new JLabel("Tarif Per Jam (Rp)"), gbc);
        gbc.gridy++;
        txtTarifPerJam = new RoundedTextField(20);
        txtTarifPerJam.setPreferredSize(new Dimension(0, 35));
        formCard.add(txtTarifPerJam, gbc);

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
        String[] columns = {"ID", "Jenis Kendaraan", "Tarif Awal", "Tarif Per Jam", "Status"};
        tableModel = TableUtil.createReadOnlyModel(columns);
        tblKendaraan = new JTable(tableModel);
        TableUtil.styleTable(tblKendaraan);

        // Center alignments
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblKendaraan.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblKendaraan.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        // Right alignments
        javax.swing.table.DefaultTableCellRenderer rightRenderer = new javax.swing.table.DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblKendaraan.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblKendaraan.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        tableCard.add(TableUtil.wrapInScrollPane(tblKendaraan), BorderLayout.CENTER);
        contentPanel.add(tableCard, BorderLayout.CENTER);

        add(contentPanel, BorderLayout.CENTER);

        // Table Click Selection
        tblKendaraan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblKendaraan.getSelectedRow();
                if (selectedRow != -1) {
                    fillFormFromSelectedRow(selectedRow);
                }
            }
        });
    }

    private void fillFormFromSelectedRow(int row) {
        txtId.setText(tableModel.getValueAt(row, 0).toString());
        txtJenis.setText(tableModel.getValueAt(row, 1).toString());
        
        // Parse money values back to plain numbers for editing
        String cleanTarifAwal = tableModel.getValueAt(row, 2).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").trim();
        String cleanTarifPerJam = tableModel.getValueAt(row, 3).toString()
                .replace("Rp ", "").replace(".", "").replace(",00", "").trim();

        txtTarifAwal.setText(cleanTarifAwal);
        txtTarifPerJam.setText(cleanTarifPerJam);
        cbStatus.setSelectedItem(tableModel.getValueAt(row, 4).toString());
        
        btnDelete.setEnabled(true);
    }

    public void resetForm() {
        txtId.setText("");
        txtJenis.setText("");
        txtTarifAwal.setText("");
        txtTarifPerJam.setText("");
        cbStatus.setSelectedIndex(0);
        btnDelete.setEnabled(false);
        tblKendaraan.clearSelection();
    }

    // Form inputs getters
    public String getIdInput() { return txtId.getText(); }
    public String getJenisInput() { return txtJenis.getText().trim(); }
    public String getTarifAwalInput() { return txtTarifAwal.getText().trim(); }
    public String getTarifPerJamInput() { return txtTarifPerJam.getText().trim(); }
    public String getStatusInput() { return cbStatus.getSelectedItem().toString(); }
    public String getSearchInput() { return txtSearch.getText().trim(); }

    // Demo Expose
    public RoundedTextField getTxtJenis() { return txtJenis; }
    public RoundedTextField getTxtTarifAwal() { return txtTarifAwal; }
    public RoundedTextField getTxtTarifPerJam() { return txtTarifPerJam; }

    // Actions
    public void addSaveListener(ActionListener l) { btnSave.addActionListener(l); }
    public void addDeleteListener(ActionListener l) { btnDelete.addActionListener(l); }
    public void addResetListener(ActionListener l) { btnReset.addActionListener(l); }
    public void addSearchListener(ActionListener l) {
        btnSearch.addActionListener(l);
        txtSearch.addActionListener(l); // Search on pressing enter
    }

    // Populate Table
    public void populateTable(List<Kendaraan> list) {
        TableUtil.clearTable(tableModel);
        for (Kendaraan k : list) {
            tableModel.addRow(new Object[]{
                    k.getIdKendaraan(),
                    k.getJenisKendaraan(),
                    CurrencyUtil.formatRupiah(k.getTarifAwal()),
                    CurrencyUtil.formatRupiah(k.getTarifPerJam()),
                    k.getStatus().toString()
            });
        }
    }
}
