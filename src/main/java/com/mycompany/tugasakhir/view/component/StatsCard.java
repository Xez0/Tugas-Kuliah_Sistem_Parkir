package com.mycompany.tugasakhir.view.component;

import com.mycompany.tugasakhir.util.VectorIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Card statistik untuk dashboard.
 * Menampilkan icon vector, judul, dan value dengan background gradient.
 */
public class StatsCard extends JPanel {

    private final String title;
    private String value;
    private final Color gradientStart;
    private final Color gradientEnd;
    private final VectorIcon.Type iconType;

    public StatsCard(String title, String value, VectorIcon.Type iconType, Color gradientStart, Color gradientEnd) {
        this.title = title;
        this.value = value;
        this.iconType = iconType;
        this.gradientStart = gradientStart;
        this.gradientEnd = gradientEnd;

        setOpaque(false);
        setPreferredSize(new Dimension(240, 110));
    }

    public void setValue(String value) {
        this.value = value;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Soft Drop Shadow
        g2d.setColor(new Color(0, 0, 0, 15));
        g2d.fill(new RoundRectangle2D.Float(2, 4, w - 4, h - 6, 16, 16));

        // Gradient background
        GradientPaint gradient = new GradientPaint(0, 0, gradientStart, w, h, gradientEnd);
        g2d.setPaint(gradient);
        g2d.fill(new RoundRectangle2D.Float(0, 0, w, h, 16, 16));

        // Draw Vector Icon in top right corner (semi-transparent white)
        VectorIcon vectorIcon = new VectorIcon(iconType, 36, new Color(255, 255, 255, 110));
        vectorIcon.paintIcon(this, g2d, w - 50, 18);

        // Title (Top Left)
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 12));
        g2d.setColor(new Color(255, 255, 255, 190));
        g2d.drawString(title.toUpperCase(), 18, 30);

        // Value (Bottom Left)
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 26));
        g2d.setColor(Color.WHITE);
        g2d.drawString(value, 18, 75);

        g2d.dispose();
    }
}
