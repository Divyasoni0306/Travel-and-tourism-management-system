package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


    public class ViewBookedhotel extends JFrame implements ActionListener {
        JButton back;
        ViewBookedhotel(String username){
            setBounds(400, 200, 1000, 600);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
            text.setFont(new Font("Tahoma", Font.BOLD, 20));
            text.setBounds(60, 10, 400, 30);
            add(text);


            JLabel lblusername = new JLabel("Email Id");
            lblusername.setBounds(30, 60, 150, 25);
            add(lblusername);

            JLabel labelusername = new JLabel();
            labelusername.setBounds(220, 60, 150, 25);
            add(labelusername);

            JLabel lblname = new JLabel("Hotel Name");
            lblname.setBounds(30, 110, 150, 25);
            add(lblname);

            JLabel labelname = new JLabel();
            labelname.setBounds(220, 110, 150, 25);
            add(labelname);

            JLabel lblpersons = new JLabel("Total Persons");
            lblpersons.setBounds(30, 160, 150, 25);
            add(lblpersons);

            JLabel labelpersons = new JLabel();
            labelpersons.setBounds(220, 160, 150, 25);
            add(labelpersons);

            JLabel lbldays = new JLabel("Total Days");
            lbldays.setBounds(30, 210, 150, 25);
            add(lbldays);


            JLabel labeldays = new JLabel();
            labeldays.setBounds(220, 210, 150, 25);
            add(labeldays);

            JLabel lblac = new JLabel("AC / Non AC");
            lblac.setBounds(30, 260, 150, 25);
            add(lblac);

            JLabel labelac = new JLabel();
            labelac.setBounds(220, 260, 150, 25);
            add(labelac);

            JLabel lblfood = new JLabel("Food Included ?");
            lblfood.setBounds(30, 310, 150, 25);
            add(lblfood);

            JLabel labelfood = new JLabel();
            labelfood.setBounds(220, 310, 150, 25);
            add(labelfood);

//            JLabel lblid = new JLabel("Id");
//            lblid.setBounds(30, 290, 150, 25);
//            add(lblid);
//
//            JLabel labelid = new JLabel();
//            labelid.setBounds(220, 290, 150, 25);
//            add(labelid);
//
//            JLabel lblnumber = new JLabel("Number");
//            lblnumber.setBounds(30, 330, 150, 25);
//            add(lblnumber);
//
//            JLabel labelnumber = new JLabel();
//            labelnumber.setBounds(220, 330, 150, 25);
//            add(labelnumber);
//
//            JLabel lblphone = new JLabel("Phone");
//            lblphone.setBounds(30, 370, 150, 25);
//            add(lblphone);
//
//            JLabel labelphone = new JLabel();
//            labelphone.setBounds(220, 370, 150, 25);
//            add(labelphone);

            JLabel lblprice = new JLabel("total Cost");
            lblprice.setBounds(30, 360, 150, 25);
            add(lblprice);

            JLabel labelprice = new JLabel();
            labelprice.setBounds(220, 360, 150, 25);
            add(labelprice);


            back= new JButton("Back");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.setBounds(130, 460, 100, 25);
            back.addActionListener(this);
            add(back);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bookeddetails.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image  = new JLabel(i3);
            image.setBounds(450, 20, 500, 400);
            add(image);



            try {
                Conn c = new Conn();
                String query = "SELECT * FROM bookhotel WHERE Email = '"+username+"' ";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    labelusername.setText(rs.getString("Email"));
                    //labelid.setText(rs.getString("Id"));
                    //labelnumber.setText(rs.getString("Number"));
                    labelname.setText(rs.getString("Name"));
                    labelprice.setText(rs.getString("Price"));
                    //labelphone.setText(rs.getString("Phone"));
                    labelpersons.setText(rs.getString("Persons"));
                    labelfood.setText(rs.getString("Food"));
                    labelac.setText(rs.getString("AC"));
                    labeldays.setText(rs.getString("Days"));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            setVisible(true);
        }


        public static void main(String[] args) {
            new ViewBookedhotel("divya");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ((e.getSource() == back)){
                setVisible(false);
            }
        }
    }




