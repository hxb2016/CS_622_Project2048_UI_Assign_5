package MainUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Purpose of this class is to create a timer pane
 */
public class GameTimerPane extends JPanel {
    private final JLabel second = new JLabel("0", SwingConstants.CENTER);

    public GameTimerPane() {
        JPanel timerPane = new JPanel();
        timerPane.setBorder(new EmptyBorder(60, 0, 0, 0));
        timerPane.setLayout(new BorderLayout());

        JLabel unit = new JLabel(" s", SwingConstants.LEFT);
        unit.setFont(new Font("Times New Roman", Font.BOLD, 50));

        this.second.setFont(new Font("Times New Roman", Font.BOLD, 50));

        timerPane.add(this.second, BorderLayout.CENTER);
        timerPane.add(unit, BorderLayout.EAST);

        this.add(timerPane);
    }
    /**
     * Purpose of this method is to set the number into timer pane
     */
    public void setSecond(String second) {
        this.second.setText(second);
    }
}
