package tourism_Management_System;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class  Signup extends JFrame implements ActionListener{

    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;
    Signup(){
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Email_Id");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
//lblusername.setLayout(null);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
//lblusername.setLayout(null);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(50, 100, 125, 25);
//lblusername.setLayout(null);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setBounds(50, 140, 125, 25);
//lblusername.setLayout(null);
        p1.add(lblsecurity);

        security = new Choice();
        security.add("Favourite Sweet");
        security.add("Favourite Marvel Superhero");
        security.add("Favourite colour");
        security.add("Favourite Cartoon");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(50, 180, 125, 25);
//lblusername.setLayout(null);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setForeground(new Color(133, 193, 233));
        create.setBackground(Color.WHITE);
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setForeground(new Color(133, 193, 233));
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);

    }
    public static void main(String[] args) {
        new Signup();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create) {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            String query ="insert into account values('"+username+"','"+name+"','"+password+"', '"+question+"', '"+answer+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
            }
            catch(Exception e1) {
                e1.printStackTrace();
            }


        }
        else if(e.getSource()==back) {
            setVisible(false);
            new Login();
        }

    }

}
