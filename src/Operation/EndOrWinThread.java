package Operation;

import Game2048_test.App;
import IO.SaveUsersData;
import Tool.OptionPane;
import Tool.UpdateTimerPane;
import Users.RegisteredUser;
import Users.User;

import javax.swing.*;
import java.util.HashMap;

public class EndOrWinThread extends Thread {
    private final User user;

    public EndOrWinThread(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        UpdateTimerPane.endTimer();

        if (Operate.isWin(user.currentBlocksArrayData)) {
            user.currentResult = "win";
            OptionPane.setJOptionPaneMessage(App.mainUI, "YOU WIN!!!", "Congratulations", null);
        } else {
            user.currentResult = "fail";
            OptionPane.setJOptionPaneMessage(App.mainUI, "GAME OVER!", "Sorry", null);
        }

        int userOption = OptionPane.setJOptionPaneConfirm(App.mainUI, "Save the result?", "Message");

        if (userOption == JOptionPane.YES_OPTION) {
            if (App.usersData == null) {
                App.usersData = new HashMap<>();
            }
            if (user instanceof RegisteredUser) {
                ((RegisteredUser) user).setData();//set the data to prepare for saving
                App.usersData.put(user.username, user);
                try {
                    SaveUsersData.saveUsersData(App.usersData, App.userDataPath);
                    App.mainUI.updateLastBestRecord();
                    App.mainUI.usersScrollPane.updateUsersTable();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                App.loginUI.setVisible(true);
            }
        }
    }
}
