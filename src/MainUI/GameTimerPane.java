package MainUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Purpose of this class is to create a timer pane
 */
public class GameTimerPane extends JPanel {
    private final JLabel second = new JLabel("0 s", SwingConstants.CENTER);

    public GameTimerPane() {
        JPanel timerPane = new JPanel();
        timerPane.setLayout(new BorderLayout());

        this.second.setFont(new Font("Times New Roman", Font.BOLD, 30));

        timerPane.add(this.second, BorderLayout.CENTER);

        this.add(timerPane);
    }
    /**
     * Purpose of this method is to set the number into timer pane
     */
    public void setSecond(String second) {
        this.second.setText(second);
    }
}
