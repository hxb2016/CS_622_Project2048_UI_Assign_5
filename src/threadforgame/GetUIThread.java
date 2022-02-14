package threadforgame;

import game2048_test.App;
import loginui.LoginUI;
import mainui.MainUI;
import profileui.ProfileUI;

public class GetUIThread extends Thread{
    public GetUIThread() {
    }

    @Override
    public void run() {
        App.mainUI = MainUI.getMainUI();//init main UI

        App.profileUI = new ProfileUI(App.mainUI);//init profile UI

        App.loginUI = LoginUI.getLoginUI(App.mainUI);//init login UI

    }
}
