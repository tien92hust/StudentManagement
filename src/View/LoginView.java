package View;

import Model.LoginModel;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private LoginModel loginModel;
//    GridBagConstraints gbc = new GridBagConstraints();

    public LoginView(){
        this.loginModel = new LoginModel();
        this.initLogin();
    }

    private void initLogin(){
        this.setTitle("Student Management");
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font inputFont = new Font("Arial",Font.BOLD,16);

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

//        --------Button---------
        JButton loginButton = new JButton("Login");
        loginButton.setFont(inputFont);
        loginButton.setPreferredSize(new Dimension(100,45));
        gbc.insets = new Insets(20,30,0,0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(loginButton, gbc);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100,45));
        cancelButton.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(cancelButton,gbc);


//        --------Top---------
        Font fontTop = new Font("Arial",Font.BOLD,32);
        JLabel userLoginLabel = new JLabel("User Login");
        userLoginLabel.setHorizontalAlignment(JLabel.CENTER);
        userLoginLabel.setFont(fontTop);
        userLoginLabel.setForeground(Color.blue);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,30,0);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLoginLabel, gbc);

//        --------Middle---------
        JLabel idLabel = new JLabel("Student ID");
        idLabel.setFont(inputFont);
        idLabel.setPreferredSize(new Dimension(90,40));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(idLabel, gbc);

        JTextField idTextField = new JTextField();
        idTextField.setPreferredSize(new Dimension(200,40));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(idTextField, gbc);

        idTextField.setFont(inputFont);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(inputFont);
        passwordLabel.setPreferredSize(new Dimension(90,40));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200,40));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);


        panel.setBackground(new Color(0xCCCCCC));
        this.add(panel);
//        this.pack();
        this.setVisible(true);
    }
}
