package ProfileUI;


import LoginUI.LoginUIButton;
import LoginUI.LoginUILabel;

import Users.User;

import javax.swing.*;
import java.awt.*;


/**
 * purpose of this class is to create a login ui interface
 */
public class ProfileUI extends JDialog {

    private static ProfileUI profilePane = null;

    private ProfileUI(JFrame owner, User user) {
        super(owner);
        this.setSize(600, 700);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JPanel photoPane = new JPanel();
        ProfilePhoto profilePhoto = new ProfilePhoto();
        profilePhoto.username.setText(user.username);
        JButton photoButton = new LoginUIButton("Edit");
        photoPane.add(profilePhoto);
        photoPane.add(photoButton);

        JPanel usernamePane = new JPanel();
        JLabel usernameTitle = new LoginUILabel("Username: ", SwingConstants.RIGHT);
        JTextField username = new ProfileTextField(user.username);
        JButton usernameButton = new LoginUIButton("Edit");
        usernamePane.add(usernameTitle);
        usernamePane.add(username);
        usernamePane.add(usernameButton);

        JPanel passwordPane = new JPanel();
        JLabel passwordTitle = new LoginUILabel("Password: ", SwingConstants.RIGHT);
        JPasswordField password = new JPasswordField(String.valueOf(user.password));
        password.setPreferredSize(new Dimension(300, 30));
        password.setForeground(new Color(18, 150, 219));
        password.setFont(new Font("Times New Roman", Font.BOLD, 18));
        password.setEditable(false);
        JButton passwordButton = new LoginUIButton("Edit");
        passwordPane.add(passwordTitle);
        passwordPane.add(password);
        passwordPane.add(passwordButton);

        JPanel agePane = new JPanel();
        JLabel ageTitle = new LoginUILabel("Age: ", SwingConstants.RIGHT);
        JTextField age = new ProfileTextField(user.age + "");
        JButton ageButton = new LoginUIButton("Edit");
        agePane.add(ageTitle);
        agePane.add(age);
        agePane.add(ageButton);

        JPanel genderPane = new JPanel();
        JLabel genderTitle = new LoginUILabel("Gender: ", SwingConstants.RIGHT);
        JTextField gender = new ProfileTextField(user.gender);
        JButton genderButton = new LoginUIButton("Edit");
        genderPane.add(genderTitle);
        genderPane.add(gender);
        genderPane.add(genderButton);

        JPanel introductionPane = new JPanel();
        JLabel introductionTitle = new LoginUILabel("Introduction: ", SwingConstants.RIGHT);
        JTextField introduction = new ProfileTextField(user.introduce);
        JButton introductionButton = new LoginUIButton("Edit");
        introductionPane.add(introductionTitle);
        introductionPane.add(introduction);
        introductionPane.add(introductionButton);

        this.add(photoPane);
        this.add(usernamePane);
        this.add(passwordPane);
        this.add(agePane);
        this.add(genderPane);
        this.add(introductionPane);

    }

    public static ProfileUI getProfileUI(JFrame f, User user) {
        if (profilePane == null) {
            profilePane = new ProfileUI(f, user);
        }
        return profilePane;
    }

}
