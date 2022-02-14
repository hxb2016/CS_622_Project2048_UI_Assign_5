package threadforgame;

import game2048_test.App;
import io.GetUsersData;

import java.io.IOException;
import java.util.HashMap;

public class GetDataThread extends Thread {


    public GetDataThread() {
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                App.usersData = GetUsersData.getUsersData(App.userDataPath);//Get users' data
                if (App.usersData == null) {
                    App.usersData = new HashMap<>();
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error happened when get data.");
                e.printStackTrace();
            }
            notifyAll();
        }
    }
}
