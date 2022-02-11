package MainUI;

import Game2048_test.App;
import Operation.Operate;
import ProfileUI.ProfileUIContent;
import Tool.CreateBlockArrayData;
import Tool.UpdateTimerPane;
import Users.UnRegisteredUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * purpose of this class is to set action listener of buttons in MainUI
 */
public class MainUIController {
    /**
     * purpose of the method is to set action listener of buttons in MainUI
     */

    public static void setUIController(MainUI mainUI) {
        // set action listener for up button in MainUI
        mainUI.up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!App.ifEnd) {
                        Operate.operation(38, App.currentUser);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // set action listener for left button in MainUI
        mainUI.left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!App.ifEnd) {
                        Operate.operation(37, App.currentUser);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // set action listener for down button in MainUI
        mainUI.down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!App.ifEnd) {
                        Operate.operation(40, App.currentUser);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // set action listener for right button in MainUI
        mainUI.right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!App.ifEnd) {
                        Operate.operation(39, App.currentUser);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // set action listener for New Game button in MainUI
        mainUI.newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateBlockArrayData.creatBlockArrayData(App.interfaceSize, App.currentUser);//init current user's block array data
                    MainUIBlocksArrayPaneUpdate.updateUI(mainUI.blocksArray, App.currentUser.currentBlocksArrayData, mainUI.blocksArrayPane);//update UI
                    UpdateTimerPane.endTimer();
                    mainUI.timerPane.setSecond("0 s");
                    Operate.ifStartOperate = false;
                    App.ifEnd = false;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });

        // set action listener for profilePhoto label in MainUI
        mainUI.profilePhoto.roundLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (App.currentUser instanceof UnRegisteredUser) {
                    App.loginUI.setVisible(true);
                } else {
                    App.profileUI.setVisible(!App.profileUI.isVisible());
                    ProfileUIContent.setProfileUIContent(App.currentUser);
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mainUI.profilePhoto.message.setText("Profile");
                mainUI.profilePhoto.roundLabel.add(mainUI.profilePhoto.message, BorderLayout.SOUTH);
                mainUI.profilePhoto.roundLabel.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainUI.profilePhoto.roundLabel.remove(mainUI.profilePhoto.message);
                mainUI.profilePhoto.roundLabel.updateUI();
            }

        });
    }
}
