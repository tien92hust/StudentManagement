package View;

import Controller.LoginController;
import Model.LoginModel;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginView extends JFrame {
    private LoginModel loginModel;
    private JButton loginButton;
    private JButton cancelButton;
    private JTextField idTextField;
    private JPasswordField passwordField;
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

        Action action = new LoginController(this);

        Font inputFont = new Font("Arial",Font.BOLD,16);

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

//        --------Button---------
        loginButton = new JButton("Login");
        loginButton.setFont(inputFont);
        loginButton.setPreferredSize(new Dimension(100,45));
        loginButton.addActionListener(action);
        gbc.insets = new Insets(20,30,0,0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(loginButton, gbc);

        cancelButton = new JButton("Reset");
        cancelButton.setPreferredSize(new Dimension(100,45));
        cancelButton.setFont(inputFont);
        cancelButton.addActionListener(action);
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

        idTextField = new JTextField();
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

        passwordField = new JPasswordField();
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

    public void successLogin(){
        Connection conn = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userJDBC = "postgres";
        String passwordJDBC = "lhyieltgjtgy1";
        String idtxt = String.valueOf(idTextField.getText());
        String passwordtxt = String.valueOf(passwordField.getPassword());
        String queryLogin = "select*from account where id='"+idTextField.getText()+"' and pass='"+passwordField.getText()+"'";

            try {
                conn = DriverManager.getConnection(url, userJDBC, passwordJDBC);
//                PreparedStatement pstmt = conn.prepareStatement(queryLogin);
//                pstmt.setString(1, idTextField.getText());
//                pstmt.setString(2, String.valueOf(passwordField.getPassword()));
                PreparedStatement pstmt = conn.prepareCall(queryLogin);
                ResultSet rs = pstmt.executeQuery();
                System.out.println(rs);
                if (idtxt.equals("")||passwordtxt.equals("")){
                    JOptionPane.showMessageDialog(this,"Please input Student ID and password");
                }else if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login success!");
                    StudentManagementView sMN = new StudentManagementView();
                    sMN.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Login fail!! Wrong ID or password");
                }
            } catch (Exception e) {

            }
        }


    public void cancelLogin() {
        idTextField.setText("");
        passwordField.setText("");
    }
}
