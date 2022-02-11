package Game2048_test;

import LoginUI.LoginUI;
import IO.GetUsersData;
import MainUI.MainUI;
import ProfileUI.ProfileUI;
import Users.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The purpose of this class is to run the game
 * Notes: In order to save time for test, I change the win number from 2048 to 16 (WinNum = 16).
 * Because it will very long time if the number is too large. which means that any number is larger than 16,
 * it will judge that you win.
 */
public class App {
    public static String photosLocation = "src" + File.separator + "Image" + File.separator + "Photos" + File.separator;
    public static String iconsLocation = "src" + File.separator + "Image" + File.separator;
    public static User currentUser = null;
    public final static int interfaceSize = 4;// Purpose of this parameter is to decide the blockArray's size
    public final static int WinNum = 16;// You will win the game, if there is any number larger than WinNum
    public static Map<String, User> usersData = null;
    public static String userDataPath = "src" + File.separator + "UserData" + File.separator + "Data.dat";
    public static MainUI mainUI = null;
    public static LoginUI loginUI = null;
    public static ProfileUI profileUI = null;
    public static boolean ifEnd = false;// Judge that the game end or not

    public static void main(String[] args) {
        try {
            usersData = GetUsersData.getUsersData(userDataPath);//Get users' data
            if (usersData == null) {
                usersData = new HashMap<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error happened when get data.");
            e.printStackTrace();
        }

        mainUI = MainUI.getMainUI();//init main UI

        loginUI = LoginUI.getLoginUI(mainUI);//init login UI

        profileUI = new ProfileUI(mainUI);//init profile UI
    }

}
