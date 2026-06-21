package com.mycompany.tugasakhir.view.component;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Custom JTextField dengan sudut bulat.
 */
public class RoundedTextField extends JTextField {

    private final int radius;
    private final Color borderColor;

    public RoundedTextField() {
        this(10);
    }

    public RoundedTextField(int radius) {
        this.radius = radius;
        this.borderColor = new Color(200, 200, 200);
        setOpaque(false);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
        setPreferredSize(new Dimension(200, 36));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius));
        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(isFocusOwner() ? new Color(233, 69, 96) : borderColor);
        g2d.setStroke(new BasicStroke(isFocusOwner() ? 2f : 1f));
        g2d.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius));
        g2d.dispose();
    }
}
