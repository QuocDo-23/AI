package View;



import javax.swing.*;

import Controller.LoginController;
import Model.Account;

import java.awt.*;

public class LoginView extends JFrame {
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private LoginController controller;

    public LoginView(LoginController controller) {
        this.controller = controller;
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        add(txtPassword);

        btnLogin = new JButton("Login");
        add(new JLabel(""));
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            Account acc = controller.login(txtEmail.getText(), new String(txtPassword.getPassword()));
            if (acc != null) {
                dispose();
                new MailboxView(acc).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Sai thông tin đăng nhập!");
            }
        });
    }
}
