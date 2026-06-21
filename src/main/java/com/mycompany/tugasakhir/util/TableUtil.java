package com.mycompany.tugasakhir.util;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

/**
 * Utility class untuk styling dan konfigurasi JTable.
 */
public class TableUtil {

    // Warna tema
    private static final Color HEADER_BG = new Color(15, 52, 96);       // #0f3460
    private static final Color HEADER_FG = Color.WHITE;
    private static final Color ROW_EVEN = new Color(255, 255, 255);
    private static final Color ROW_ODD = new Color(240, 242, 245);      // #f0f2f5
    private static final Color SELECTION_BG = new Color(233, 69, 96);   // #e94560
    private static final Color SELECTION_FG = Color.WHITE;
    private static final Color GRID_COLOR = new Color(220, 220, 220);

    /**
     * Styling JTable agar terlihat modern dan profesional.
     */
    public static void styleTable(JTable table) {
        // Font
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(32);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setGridColor(GRID_COLOR);
        table.setIntercellSpacing(new Dimension(0, 1));

        // Selection
        table.setSelectionBackground(SELECTION_BG);
        table.setSelectionForeground(SELECTION_FG);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Header
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setBackground(HEADER_BG);
        header.setForeground(HEADER_FG);
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 38));
        header.setReorderingAllowed(false);

        // Center alignment for header
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setBackground(HEADER_BG);
        headerRenderer.setForeground(HEADER_FG);
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 13));
        header.setDefaultRenderer(headerRenderer);

        // Alternating row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? ROW_EVEN : ROW_ODD);
                }
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
                return c;
            }
        });
    }

    /**
     * Buat DefaultTableModel yang tidak bisa diedit langsung.
     */
    public static DefaultTableModel createReadOnlyModel(String[] columns) {
        return new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    /**
     * Bersihkan semua baris dari tabel.
     */
    public static void clearTable(DefaultTableModel model) {
        model.setRowCount(0);
    }

    /**
     * Setup JScrollPane untuk tabel.
     */
    public static JScrollPane wrapInScrollPane(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        scrollPane.getViewport().setBackground(Color.WHITE);
        return scrollPane;
    }
}
