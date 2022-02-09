package Tool;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

public class FileChooserForPhoto {
    public static JFileChooser getFileChooser() {
        JFileChooser fc = null;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            fc = new JFileChooser();
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            fc = new JFileChooser();
            e.printStackTrace();
        }

        fc.setDialogTitle("Choose Photo");
        fc.setPreferredSize(new Dimension(500, 400));
        fc.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return ".png .jpg .gif";
            }

            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(".png") || f.getName().endsWith(".jpg")||f.getName().endsWith(".gif");
            }
        });

        return fc;
    }
}
