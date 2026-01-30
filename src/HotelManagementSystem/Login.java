package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField usernameTextField;
    JPasswordField passwordTextField;

    Login(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons_Hotel/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(380,20,320,320);
        add(icon);

        JLabel usernameLabel=new JLabel("Username");
        usernameLabel.setBounds(30,50,150,30);
        usernameLabel.setFont(new Font("System",Font.BOLD,25));
        add(usernameLabel);

        usernameTextField=new JTextField();
        usernameTextField.setBounds(190,50,200,30);
        usernameTextField.setFont(new Font("Ariel",Font.PLAIN,22));
        add(usernameTextField);

        JLabel passwordLabel =new JLabel("Password");
        passwordLabel.setBounds(30,120,150,30);
        passwordLabel.setFont(new Font("System",Font.BOLD,25));
        add(passwordLabel);

        passwordTextField =new JPasswordField();
        passwordTextField.setBounds(190,120,200,30);
        passwordTextField.setFont(new Font("Ariel",Font.PLAIN,22));
        add(passwordTextField);

        login=new JButton("Login");
        login.setBounds(30,200,170,35);
        login.setFont(new Font("System",Font.BOLD,20));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel =new JButton("Cancel");
        cancel.setBounds(220,200,170,35);
        cancel.setFont(new Font("System",Font.BOLD,20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(700,400);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
        } else if (ae.getSource()==login) {
            if(usernameTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Username cannot be empty");
            }else if(passwordTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Password cannot be empty");
            }else {

                String username = usernameTextField.getText();
                String password = passwordTextField.getText();

                try {
                    Conn c = new Conn();
                    String query = "select * from login where username='" + username + "' and password='" + password + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        setVisible(false);
                        new Dashboard();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
