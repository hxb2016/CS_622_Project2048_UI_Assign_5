package Tool;

import Game2048_test.App;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CopyFile {
    public static void copyFile(String oldPath) {
        int dotLocation = oldPath.lastIndexOf(".");
        String end = oldPath.substring(dotLocation);
        File oldName = new File(oldPath);
        File newName = new File(App.photosLocation + App.currentUser.username + end);
        try {
            if (newName.exists()) {
                if (newName.delete()) {
                    Files.copy(oldName.toPath(), newName.toPath());
                }
            } else {
                Files.copy(oldName.toPath(), newName.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
