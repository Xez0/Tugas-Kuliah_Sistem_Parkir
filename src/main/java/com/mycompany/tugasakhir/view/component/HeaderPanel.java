package com.mycompany.tugasakhir.view.component;

import com.mycompany.tugasakhir.util.SessionManager;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Panel header untuk bagian atas dashboard.
 * Menampilkan judul halaman, info user login, dan jam realtime.
 */
public class HeaderPanel extends JPanel {

    private final JLabel lblTitle;
    private final JLabel lblClock;
    private final JLabel lblUser;
    private Timer clockTimer;

    private static final Color BG_COLOR = new Color(15, 52, 96);   // #0f3460

    public HeaderPanel() {
        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(0, 55));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Title
        lblTitle = new JLabel("Dashboard");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);

        // Clock
        lblClock = new JLabel();
        lblClock.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblClock.setForeground(new Color(200, 200, 200));

        // User info
        lblUser = new JLabel();
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblUser.setForeground(new Color(200, 200, 200));
        updateUserInfo();

        // Right panel with clock and user
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        rightPanel.setOpaque(false);

        // User badge
        JPanel userBadge = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        userBadge.setOpaque(false);
        JLabel userIcon = new JLabel(new com.mycompany.tugasakhir.util.VectorIcon(com.mycompany.tugasakhir.util.VectorIcon.Type.USER, 16, new Color(200, 200, 200)));
        userBadge.add(userIcon);
        userBadge.add(lblUser);

        rightPanel.add(userBadge);
        rightPanel.add(lblClock);

        add(lblTitle, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        // Start clock timer
        startClock();
    }

    public void setTitle(String title) {
        lblTitle.setText(title);
    }

    public void updateUserInfo() {
        String username = SessionManager.getCurrentUsername();
        String role = SessionManager.getCurrentRole();
        lblUser.setText(username + " (" + role + ")");
    }

    private void startClock() {
        clockTimer = new Timer(1000, e -> {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss"));
            lblClock.setText(time);
        });
        clockTimer.start();
    }

    public void stopClock() {
        if (clockTimer != null) {
            clockTimer.stop();
        }
    }
}
