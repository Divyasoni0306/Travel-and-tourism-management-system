package tourism_Management_System;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassword;
    JButton login, signup, Password;


    Login() {
        setSize(900, 400);
        setLocation(350,200);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(100, 90, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.gray);
        p2.setLayout(null);

        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblusername = new JLabel("Email_Id");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));

        p2.add(lblusername);

        tfusername =  new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

        tfpassword =  new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        Password = new JButton("Forgot Password");
        Password.setBounds(130, 250, 130, 30);
        Password.setBackground(new Color(133, 193, 233));
        Password.setForeground(Color.WHITE);
        Password.setBorder(new LineBorder(new Color(133, 193, 233)));
        Password.addActionListener(this);
        p2.add(Password);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300, 250, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }


    public static void main(String[] args) {
        Login l = new Login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            try{
               String Username = tfusername.getText();
                String Password = tfpassword.getText();

                String query = "select * from account where Email = '"+Username+"' AND Password = '"+Password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(Username);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Email_Id and Password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        else if (e.getSource() == signup) {
            setVisible(false);
            new Signup();
        }
        else {
            setVisible(false);
            new ForgetPassword();
        }

    }

}
