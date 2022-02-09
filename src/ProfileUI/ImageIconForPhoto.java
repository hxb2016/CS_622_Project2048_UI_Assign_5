package ProfileUI;

import Tool.RoundLabel;

import javax.swing.*;
import java.awt.*;

public class ImageIconForPhoto extends ImageIcon {
    public ImageIconForPhoto(String path) {
        super(path);
        if (this.getIconWidth() > this.getIconHeight()) {
            setImageByWidth(this);
        } else {
            setImageByHeight(this);
        }
    }

    public void setImageByHeight(ImageIcon icon) {
        int imgHeight = icon.getIconHeight();
        int imgWight = icon.getIconWidth();
        double rate = (double) imgWight / imgHeight;

        int realImgHeight = RoundLabel.photoSize;
        int realImgWight = (int) (rate * realImgHeight);
        icon.setImage(icon.getImage().getScaledInstance(realImgWight, realImgHeight, Image.SCALE_SMOOTH));
    }

    public void setImageByWidth(ImageIcon icon) {
        int imgHeight = icon.getIconHeight();
        int imgWight = icon.getIconWidth();
        double rate = (double) imgHeight / imgWight;

        int realImgWight = RoundLabel.photoSize;
        int realImgHeight = (int) (rate * realImgWight);
        icon.setImage(icon.getImage().getScaledInstance(realImgWight, realImgHeight, Image.SCALE_SMOOTH));
    }
}