package Tool;

import Game2048_test.App;

import java.util.Timer;
import java.util.TimerTask;

/**
 * purpose of this class is to update timer pane
 */
public class UpdateTimerPane {
    private static int second = 0;
    private static Timer timer = new Timer();
    /**
     * purpose of this method is to launch the timer
     */
    public static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                App.mainUI.timerPane.setSecond(second + "");
                second++;
            }
        }, 0, 1000);
    }
    /**
     * purpose of this method is to end the timer
     */
    public static void endTimer() {
        App.currentUser.currentTakeTime = second - 1;//set taken time
        timer.cancel();
        second = 0;
    }
}
