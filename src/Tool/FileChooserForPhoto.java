package Tool;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

/**
 * Purpose of this class is to return a FileChooser for profile interface
 */
public class FileChooserForPhoto {
    public static JFileChooser getFileChooser() {
        JFileChooser fc = null;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            fc = new ThumbnailFileChooser();
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            fc = new ThumbnailFileChooser();
            e.printStackTrace();
        }

        fc.setDialogTitle("Choose Photo");
        fc.setPreferredSize(new Dimension(500, 400));
        fc.setFileFilter(new FileFilter() {
            @Override
            public String getDescription() {
                return ".png .jpg .jpeg .gif";
            }

            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(".png") || f.getName().endsWith(".jpg") || f.getName().endsWith(".jpeg") || f.getName().endsWith(".gif");
            }
        });

        return fc;
    }
}
