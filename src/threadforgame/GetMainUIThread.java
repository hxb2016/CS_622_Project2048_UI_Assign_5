package threadforgame;

import game2048_test.App;
import mainui.MainUI;

/**
 * Purpose of this class is to create a GetUIThread thread for init interface
 * <p>
 * Author: Xiaobing Hou
 * Date: 02/12/2022
 * Course: CS-622
 */
public class GetMainUIThread extends Thread {

    public GetMainUIThread() {

    }

    @Override
    public void run() {
        App.mainUI = MainUI.getMainUI();//init main UI
    }
}
