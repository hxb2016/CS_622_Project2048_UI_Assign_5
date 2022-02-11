package ProfileUI;

import javax.swing.*;
import java.awt.*;

/**
 * purpose of this class is to create a profile interface
 */
public class ProfileUI extends JDialog {

    public ProfileUI(JFrame f) {
        super(f);
        this.setSize(500, 510);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }

}
