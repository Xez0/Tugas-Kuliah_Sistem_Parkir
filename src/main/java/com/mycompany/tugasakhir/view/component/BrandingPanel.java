package com.mycompany.tugasakhir.view.component;

import javax.swing.*;
import java.awt.*;

/**
 * Panel kustom untuk branding/dekorasi latar belakang dengan gradasi 
 * dan hiasan lingkaran artistik.
 */
public class BrandingPanel extends JPanel {

    public BrandingPanel() {
        // Biarkan transparan jika diletakkan di atas kontainer lain, 
        // tetapi kita akan menggambar background sendiri.
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Gradasi warna Navy Gelap ke Navy Terang
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(26, 26, 46), 
                getWidth(), getHeight(), new Color(15, 52, 96)
        );
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Gambar lingkaran dekorasi artistik di sudut
        g2.setColor(new Color(233, 69, 96, 40)); // Red accent dengan alpha transparan
        g2.fillOval(-50, -50, 200, 200);
        g2.fillOval(getWidth() - 100, getHeight() - 100, 150, 150);

        g2.dispose();
    }
}
