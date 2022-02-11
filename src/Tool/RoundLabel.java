package Tool;

import ProfileUI.ImageIconForPhoto;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Purpose of the class is to creat a round label to contain profile photo
 */
public class RoundLabel extends JLabel {
    public static int photoSize = 128;

    public RoundLabel(String path) {
        this.setPreferredSize(new Dimension(photoSize, photoSize));
        this.setLayout(new BorderLayout());
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        ImageIconForPhoto icon = new ImageIconForPhoto(path);
        this.setIcon(icon);
    }

    public void paint(Graphics g) {
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), photoSize, photoSize);
        g.setClip(rect);
        super.paint(g);
    }
}
