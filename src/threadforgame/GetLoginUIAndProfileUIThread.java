package threadforgame;

import game2048_test.App;
import loginui.LoginUI;
import mainui.MainUI;
import profileui.ProfileUI;
/**
 * Purpose of this class is to create a GetLoginUIAndProfileUIThread thread for getting loginUI And profileUI
 * Author: Xiaobing Hou
 * Date: 02/12/2022
 * Course: CS-622
 */
public class GetLoginUIAndProfileUIThread extends Thread {
    private final MainUI mainUI;

    public GetLoginUIAndProfileUIThread(MainUI mainUI) {
        this.mainUI = mainUI;
    }

    @Override
    public void run() {
        App.profileUI = new ProfileUI(mainUI);//init profile UI
        App.loginUI = LoginUI.getLoginUI(mainUI);//init login UI
    }
}
