package com.mycompany.tugasakhir.view.component;

import com.mycompany.tugasakhir.util.VectorIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Tombol navigasi kustom untuk Sidebar Dashboard.
 * Menangani hover effect dan melukis indikator vertikal aktif di sisi kiri.
 */
public class NavButton extends JButton {

    private boolean active = false;
    private String cardName = "";
    private VectorIcon.Type iconType;
    private final Color defaultBg = new Color(26, 26, 46); // #1a1a2e
    private final Color hoverBg = new Color(22, 33, 62);   // #16213e
    private final Color activeBg = new Color(15, 52, 96);   // #0f3460
    private final Color defaultFg = new Color(200, 200, 200);
    private final Color activeIndicatorColor = new Color(233, 69, 96); // #e94560

    public NavButton() {
        initComponents();
    }

    public NavButton(String text, String cardName, VectorIcon.Type iconType) {
        super(text);
        this.cardName = cardName;
        this.iconType = iconType;
        initComponents();
        updateVisuals();
    }

    private void initComponents() {
        setFont(new Font("Segoe UI", Font.BOLD, 13));
        setForeground(defaultFg);
        setBackground(defaultBg);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalAlignment(SwingConstants.LEFT);
        setPreferredSize(new Dimension(220, 42));
        setIconTextGap(12);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                if (!active) {
                    setBackground(hoverBg);
                    setForeground(Color.WHITE);
                    setIconColor(Color.WHITE);
                }
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (!active) {
                    if ("LOGOUT".equals(cardName)) {
                        setBackground(activeIndicatorColor);
                        setForeground(Color.WHITE);
                        setIconColor(Color.WHITE);
                    } else {
                        setBackground(defaultBg);
                        setForeground(defaultFg);
                        setIconColor(defaultFg);
                    }
                }
            }
        });
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        updateVisuals();
        repaint();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
        updateVisuals();
    }

    public VectorIcon.Type getIconType() {
        return iconType;
    }

    public void setIconType(VectorIcon.Type iconType) {
        this.iconType = iconType;
        updateVisuals();
    }

    private void setIconColor(Color color) {
        if (iconType != null) {
            setIcon(new VectorIcon(iconType, 18, 18, color));
        }
    }

    public void updateVisuals() {
        if (active) {
            setBackground(activeBg);
            setForeground(Color.WHITE);
            setIconColor(Color.WHITE);
        } else {
            if ("LOGOUT".equals(cardName)) {
                setBackground(activeIndicatorColor); // Logout button is always red-ish
                setForeground(Color.WHITE);
                setIconColor(Color.WHITE);
            } else {
                setBackground(defaultBg);
                setForeground(defaultFg);
                setIconColor(defaultFg);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
        if (active) {
            g.setColor(activeIndicatorColor);
            g.fillRect(0, 0, 4, getHeight());
        }
    }
}
