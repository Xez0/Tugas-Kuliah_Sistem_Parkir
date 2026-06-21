package com.mycompany.tugasakhir.util;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Utilitas kustom untuk memberikan sentuhan desain yang luas, lega, modern, dan premium
 * secara dinamis pada semua panel menu aplikasi (Tanpa mengganggu file .form NetBeans).
 */
public class UIStyleUtil {

    public static void styleView(JFrame frame) {
        if (frame == null) return;
        styleContainer(frame.getContentPane());
    }

    private static void styleContainer(Container container) {
        if (container == null) return;

        for (Component comp : container.getComponents()) {
            // 1. Deteksi Sidebar Panel
            if (comp instanceof JPanel && comp.getBackground() != null && 
                (comp.getBackground().equals(new Color(26, 26, 46)) || comp.getBackground().getRGB() == new Color(26, 26, 46).getRGB())) {
                
                JPanel sidebar = (JPanel) comp;
                int h = sidebar.getPreferredSize().height;
                sidebar.setPreferredSize(new Dimension(250, h > 0 ? h : 700));
                
                for (Component sComp : sidebar.getComponents()) {
                    if (sComp instanceof JButton) {
                        JButton btn = (JButton) sComp;
                        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                        btn.setPreferredSize(new Dimension(250, 48));
                        btn.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
                    } else if (sComp instanceof JLabel) {
                        JLabel lbl = (JLabel) sComp;
                        if (lbl.getText().trim().equalsIgnoreCase("PARKIRKU")) {
                            lbl.setFont(new Font("Segoe UI", Font.BOLD, 24));
                        }
                    }
                }
            }

            // 2. Deteksi Header Panel
            else if (comp instanceof JPanel && comp.getBackground() != null && 
                comp.getBackground().equals(new Color(15, 52, 96))) {
                
                JPanel header = (JPanel) comp;
                header.setPreferredSize(new Dimension(header.getPreferredSize().width, 60));
                
                for (Component hComp : header.getComponents()) {
                    if (hComp instanceof JLabel) {
                        JLabel lbl = (JLabel) hComp;
                        if (lbl.getFont().getSize() >= 18) {
                            lbl.setFont(new Font("Segoe UI", Font.BOLD, 22));
                        }
                    } else if (hComp instanceof JPanel) {
                        styleContainer((JPanel) hComp);
                    }
                }
            }

            // 3. Deteksi Content Area utama
            else if (comp instanceof JPanel && comp.getBackground() != null && 
                comp.getBackground().equals(new Color(240, 242, 245))) {
                
                JPanel content = (JPanel) comp;
                content.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
                styleContainer(content);
            }

            // 4. Deteksi Form Card input
            else if (comp instanceof JPanel && comp.getBackground() != null && 
                     comp.getBackground().equals(Color.WHITE) && 
                     ((JPanel) comp).getLayout() instanceof GridBagLayout) {
                
                JPanel formCard = (JPanel) comp;
                // Perlebar panel form agar tidak sempit
                int h = formCard.getPreferredSize().height;
                formCard.setPreferredSize(new Dimension(390, h > 0 ? h : 600));
                formCard.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
                    BorderFactory.createEmptyBorder(25, 25, 25, 25)
                ));

                // Style semua input di dalam form
                for (Component fComp : formCard.getComponents()) {
                    if (fComp instanceof JTextField || fComp instanceof JComboBox || 
                        fComp instanceof JPasswordField || fComp.getClass().getName().contains("DateChooser")) {
                        
                        JComponent input = (JComponent) fComp;
                        input.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                        input.setPreferredSize(new Dimension(input.getPreferredSize().width, 38));
                        
                        if (input instanceof JTextField || input instanceof JPasswordField) {
                            input.setBorder(BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                                BorderFactory.createEmptyBorder(6, 12, 6, 12)
                            ));
                        }
                    } else if (fComp instanceof JLabel) {
                        JLabel lbl = (JLabel) fComp;
                        // Banner title di dalam form
                        if (lbl.getFont().getSize() >= 15) {
                            lbl.setFont(new Font("Segoe UI", Font.BOLD, 17));
                            lbl.setForeground(new Color(15, 52, 96));
                        } else {
                            lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
                            lbl.setForeground(new Color(60, 60, 60));
                        }
                    } else if (fComp instanceof JPanel) {
                        // Button panel (simpan, hapus, batal)
                        styleContainer((JPanel) fComp);
                    }
                }
            }

            // 5. Deteksi Table Card / Panel Data
            else if (comp instanceof JPanel && comp.getBackground() != null && 
                     comp.getBackground().equals(Color.WHITE)) {
                
                JPanel tableCard = (JPanel) comp;
                tableCard.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
                    BorderFactory.createEmptyBorder(20, 20, 20, 20)
                ));
                styleContainer(tableCard);
            }

            // 6. Penyesuaian tombol aksi kustom di dalam GridLayout
            else if (comp instanceof JPanel && ((JPanel) comp).getLayout() instanceof GridLayout) {
                JPanel btnPanel = (JPanel) comp;
                for (Component bComp : btnPanel.getComponents()) {
                    if (bComp instanceof JButton) {
                        JButton btn = (JButton) bComp;
                        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
                        btn.setPreferredSize(new Dimension(btn.getPreferredSize().width, 38));
                    }
                }
            }

            // 7. Penyesuaian ScrollPane & Table
            else if (comp instanceof JScrollPane) {
                JScrollPane scroll = (JScrollPane) comp;
                scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
                Component view = scroll.getViewport().getView();
                if (view instanceof JTable) {
                    JTable table = (JTable) view;
                    table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    table.setRowHeight(36);
                    table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
                    table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getPreferredSize().width, 42));
                }
            }

            // 8. Pencarian rekursif untuk panel container umum lainnya
            else if (comp instanceof Container) {
                styleContainer((Container) comp);
            }
        }
    }
}
