package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;
    ViewCustomer(String Username){
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Email Id");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Verification Id Type");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Verification Id Number");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(500, 50, 150, 25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(690, 50, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 110, 150, 25);
        add(lblcountry);

        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690, 110, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 170, 150, 25);
        add(lbladdress);

        JLabel labeladddress = new JLabel();
        labeladddress.setBounds(690, 170, 150, 25);
        add(labeladddress);


        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 230, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 230, 150, 25);
        add(labelphone);

//        JLabel lblemail = new JLabel("Email");
//        lblemail.setBounds(500, 230, 150, 25);
//        add(lblemail);
//
//        JLabel labelemail = new JLabel();
//        labelemail.setBounds(690, 230, 150, 25);
//        add(labelemail);


        back= new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/viewall.jpg"));
        Image i5 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1  = new JLabel(i6);
        image1.setBounds(600, 400, 600, 200);
        add(image1);

        try {
            Conn c = new Conn();
            String query = "SELECT * FROM customer WHERE Email = '"+Username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("Email"));
                labelid.setText(rs.getString("Id"));
                labelnumber.setText(rs.getString("Number"));
                labelname.setText(rs.getString("Name"));
                labelgender.setText(rs.getString("Gender"));
                labeladddress.setText(rs.getString("Address"));
                labelphone.setText(rs.getString("Phone"));
                //labelemail.setText(rs.getString("Email"));
                labelcountry.setText(rs.getString("Country"));


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        setVisible(true);
    }


    public static void main(String[] args) {
        new ViewCustomer("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == back)){
            setVisible(false);
        }
    }
}
