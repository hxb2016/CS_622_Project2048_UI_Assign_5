package Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundLabel extends JLabel {
    private final int roundSize;
    private final int size;

    public RoundLabel(int roundSize, int size) {
        this.roundSize = roundSize;
        this.size = size;
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
    }

    public void paint(Graphics g) {
        RoundRectangle2D.Double rect = new RoundRectangle2D.Double(0, 0, size, size, roundSize, roundSize);
        g.setClip(rect);
        super.paint(g);
    }
}
