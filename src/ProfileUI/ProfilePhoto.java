package ProfileUI;

import Tool.RoundLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class ProfilePhoto extends JPanel {
    public RoundLabel roundLabel;
    public JLabel username;

    public ProfilePhoto() {
        ImageIcon photo = new ImageIcon("src" + File.separator + "Image" + File.separator + "profile1.png");
        roundLabel = new RoundLabel(photo.getIconWidth(), photo.getIconWidth());
        roundLabel.setLayout(new BorderLayout());
        roundLabel.setIcon(photo);

        JLabel message = new JLabel("ProfileUI", SwingConstants.CENTER);
        message.setOpaque(true);
        message.setBackground(new Color(0, 0, 0, 100));
        message.setBorder(new EmptyBorder(0, 0, 5, 0));
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Times New Roman", Font.BOLD, 12));

        username = new JLabel("", SwingConstants.CENTER);
        username.setPreferredSize(new Dimension(200,20));
        username.setForeground(new Color(200,170,100));
        username.setFont(new Font("Times New Roman", Font.BOLD, 16));

        roundLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                roundLabel.add(message, BorderLayout.SOUTH);
                roundLabel.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                roundLabel.remove(message);
                roundLabel.updateUI();
            }
        });
        this.setPreferredSize(new Dimension(150,200));
        this.add(roundLabel);
        this.add(username);
    }
}
