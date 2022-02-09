package ProfileUI;

import Game2048_test.App;
import LoginUI.LoginUIButton;
import LoginUI.LoginUILabel;
import Users.User;

import javax.swing.*;
import java.awt.*;

/**
 * purpose of this class is to create a login ui interface
 */
public class ProfileUIContent extends JPanel {

    public ProfilePhoto profilePhoto = new ProfilePhoto(App.currentUser);
    public JTextField username = new ProfileTextField(App.currentUser.username);
    public JTextField gender = new ProfileTextField(App.currentUser.gender);
    public JTextField age = new ProfileTextField(App.currentUser.age + "");
    public JTextField introduction = new ProfileTextField(App.currentUser.introduce);
    public JPasswordField password = null;
    public JButton editButton = null;

    private static ProfileUIContent profileUIContent=null;

    private ProfileUIContent(User user) {
        JPanel topPanel = new JPanel();
        profilePhoto.username.setText(user.username);
        topPanel.add(profilePhoto);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(6, 1));

        JPanel usernamePane = new JPanel();
        JLabel usernameTitle = new LoginUILabel("Username: ", SwingConstants.RIGHT);
        usernamePane.add(usernameTitle);
        usernamePane.add(username);

        JPanel passwordPane = new JPanel();
        JLabel passwordTitle = new LoginUILabel("Password: ", SwingConstants.RIGHT);
        password = new JPasswordField(String.valueOf(user.password));
        password.setPreferredSize(new Dimension(300, 30));
        password.setForeground(new Color(18, 150, 219));
        password.setFont(new Font("Times New Roman", Font.BOLD, 18));
        password.setEditable(false);
        passwordPane.add(passwordTitle);
        passwordPane.add(password);

        JPanel agePane = new JPanel();
        JLabel ageTitle = new LoginUILabel("Age: ", SwingConstants.RIGHT);
        agePane.add(ageTitle);
        agePane.add(age);

        JPanel genderPane = new JPanel();
        JLabel genderTitle = new LoginUILabel("Gender: ", SwingConstants.RIGHT);
        genderPane.add(genderTitle);
        genderPane.add(gender);

        JPanel introductionPane = new JPanel();
        JLabel introductionTitle = new LoginUILabel("Intr: ", SwingConstants.RIGHT);
        introductionPane.add(introductionTitle);
        introductionPane.add(introduction);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        editButton = new LoginUIButton("Edit");
        editButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        buttonPanel.add(editButton);

        bottomPanel.add(usernamePane);
        bottomPanel.add(passwordPane);
        bottomPanel.add(agePane);
        bottomPanel.add(genderPane);
        bottomPanel.add(introductionPane);
        bottomPanel.add(buttonPanel);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.CENTER);
    }

    public static void setProfileUIContent(User user) {
        if (profileUIContent == null) {
            profileUIContent = new ProfileUIContent(user);
            App.profileUI.add(profileUIContent,BorderLayout.CENTER);
            ProfileUIController.setController(profileUIContent);
        }
    }

}
