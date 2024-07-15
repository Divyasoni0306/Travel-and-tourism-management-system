package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


    public class ViewPackage extends JFrame implements ActionListener {
        JButton back;
        ViewPackage(String username){
            setBounds(450, 200, 900, 450);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel text = new JLabel("VIEW PACKAGE DETAILS");
            text.setFont(new Font("Tahoma", Font.BOLD, 20));
            text.setBounds(60, 10, 300, 30);
            add(text);


            JLabel lblusername = new JLabel("Email Id");
            lblusername.setBounds(30, 60, 150, 25);
            add(lblusername);

            JLabel labelusername = new JLabel();
            labelusername.setBounds(220, 60, 150, 25);
            add(labelusername);

            JLabel lblid = new JLabel("Package");
            lblid.setBounds(30, 110, 150, 25);
            add(lblid);

            JLabel labelpackage = new JLabel();
            labelpackage.setBounds(220, 110, 150, 25);
            add(labelpackage);

            JLabel lblnumber = new JLabel("Total Persons");
            lblnumber.setBounds(30, 160, 150, 25);
            add(lblnumber);

            JLabel labelpersons = new JLabel();
            labelpersons.setBounds(220, 160, 150, 25);
            add(labelpersons);

//            JLabel lblname = new JLabel("Id");
//            lblname.setBounds(30, 170, 150, 25);
//            add(lblname);
//
//            JLabel labelid = new JLabel();
//            labelid.setBounds(220, 170, 150, 25);
//            add(labelid);
//
//            JLabel lblgender = new JLabel("Number");
//            lblgender.setBounds(30, 210, 150, 25);
//            add(lblgender);
//
//            JLabel labelnumber = new JLabel();
//            labelnumber.setBounds(220, 210, 150, 25);
//            add(labelnumber);
//
//            JLabel lblcountry = new JLabel("Phone");
//            lblcountry.setBounds(30, 250, 150, 25);
//            add(lblcountry);
//
//            JLabel labelphone = new JLabel();
//            labelphone.setBounds(220, 250, 150, 25);
//            add(labelphone);

            JLabel lbladdress = new JLabel("Price");
            lbladdress.setBounds(30, 210, 150, 25);
            add(lbladdress);

            JLabel labelprice = new JLabel();
            labelprice.setBounds(220, 210, 150, 25);
            add(labelprice);


            back= new JButton("Back");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.setBounds(130, 360, 100, 25);
            back.addActionListener(this);
            add(back);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bookeddetails.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image  = new JLabel(i3);
            image.setBounds(20, 400, 600, 200);
            add(image);

            ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/viewall.jpg"));
            Image i5 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            JLabel image1  = new JLabel(i6);
            image1.setBounds(420, 20, 500, 400);
            add(image1);

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM bookpackage WHERE Email = '"+username+"' ";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    labelusername.setText(rs.getString("Email"));
                    //labelid.setText(rs.getString("Id"));
                    //labelnumber.setText(rs.getString("Number"));
                    labelpackage.setText(rs.getString("Package"));
                    labelprice.setText(rs.getString("Price"));
                    //labelphone.setText(rs.getString("Phone"));
                    labelpersons.setText(rs.getString("Persons"));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            setVisible(true);
        }


        public static void main(String[] args) {
            new ViewPackage("divya");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((e.getSource() == back)){
                setVisible(false);
            }
        }
    }


