package ProfileUI;

import javax.swing.*;
import java.awt.*;

/**
 * purpose of this class is to create text box component for typing from users
 */
public class ProfileTextField extends JTextField {
    public ProfileTextField(String message) {
        this.setPreferredSize(new Dimension(300,30));
        this.setForeground(new Color(18,150,219));
        this.setFont(new Font("Times New Roman",Font.BOLD,18));
        this.setEditable(false);
        this.setText(message);
    }
}
