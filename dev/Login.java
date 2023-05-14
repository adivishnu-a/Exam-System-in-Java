import javax.swing.*;

public class Login extends JFrame{
    private JPanel LoginPanel;
    private JLabel LoginHeader;
    private JTextField usernameField;
    private JLabel username;
    private JLabel password;
    private JButton loginButton;
    private JButton newUserSignUpButton;
    private JPasswordField passwordField;

    public static void main(String[] args){
        Login l = new Login();
        l.setContentPane(new Login().LoginPanel);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setVisible(true);
        l.pack();
    }
}
