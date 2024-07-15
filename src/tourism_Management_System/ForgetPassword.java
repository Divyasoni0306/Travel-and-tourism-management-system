package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        p1.setBackground(new Color(133, 193, 233));
        add(p1);

        JLabel lblusername = new JLabel("Email Id");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(40, 20, 100, 25);
        p1.add(lblusername);



        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());

        p1.add(tfusername);

        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma", Font.BOLD, 14));
        search.setBounds(380, 20, 100, 20);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(40, 60, 100, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblquestion.setBounds(40, 100, 150, 25);
        p1.add(lblquestion);



        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(40, 140, 125, 25);
        p1.add(lblanswer);



        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);



        retrieve = new JButton("Retrieve");
        retrieve.setForeground(Color.WHITE);
        retrieve.setBackground(Color.GRAY);
        retrieve.setFont(new Font("Tahoma", Font.BOLD, 14));
        retrieve.setBounds(380, 140, 100, 20);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(40, 180, 150, 25);
        p1.add(lblpassword);



        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);



        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.GRAY);
        back.setFont(new Font("", Font.BOLD, 14));
        back.setBounds(200, 230, 100, 30);
        back.addActionListener(this);
        p1.add(back);


        setVisible(true);

    }


    public static void main(String[] args) {
        new ForgetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== search) {

            try {

                String query = "SELECT * FROM account WHERE Email = '"+tfusername.getText()+"'";

                Conn c = new Conn();



                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()) {

                    tfname.setText( rs.getString("Name"));

                    tfquestion.setText(rs.getString("Security"));

                }

            }

            catch(Exception e1) {

                e1.printStackTrace();

            }



        }

        else if (e.getSource()== retrieve) {

            try {

                String query = "SELECT * FROM account WHERE Answer = '"+tfanswer.getText()+"' AND Email = '"+tfusername.getText()+"'";

                Conn c = new Conn();



                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()) {

                    tfpassword.setText( rs.getString("Password"));



                }

            }

            catch(Exception e1) {

                e1.printStackTrace();

            }

        }

        else {

            setVisible(false);

            new Login();

        }

    }
    }

