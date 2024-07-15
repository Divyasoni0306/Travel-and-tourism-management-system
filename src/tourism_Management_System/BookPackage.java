package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField tfpersons, labelid, labelnumber, labelphone, labelprice, labelusername;
    String Username;
    JLabel lblusername;
    JButton checkprice , back , bookpackage;

    BookPackage(String Username){
        this.Username = Username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        lblusername = new JLabel("Email Id");
        lblusername.setBounds(40, 90, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JTextField();
        labelusername.setBounds(250, 90, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40, 140, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 140, 200,20);
        add(cpackage);

        JLabel lblpersons = new JLabel("Total Persons ");
        lblpersons.setBounds(40, 190, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 190, 200, 25);
        add(tfpersons);


//        JLabel lblid = new JLabel("Id");
//        lblid.setBounds(40, 190, 150, 20);
//        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblid);
//
//        labelid = new JTextField();
//        labelid.setBounds(250, 190, 200, 25);
//        add(labelid);
//
//        JLabel lblnumber = new JLabel("Number");
//        lblnumber.setBounds(40, 230, 150, 25);
//        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblnumber);
//
//        labelnumber = new JTextField();
//        labelnumber.setBounds(250, 230, 150, 25);
//        add(labelnumber);
//
//        JLabel lblphone = new JLabel("Phone");
//        lblphone.setBounds(40, 270, 150, 25);
//        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblphone);
//
//        labelphone = new JTextField();
//        labelphone.setBounds(250, 270, 150, 25);
//        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 240, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labelprice = new JTextField();
        labelprice.setBounds(250, 240, 150, 25);
        add(labelprice);


        try {
            Conn c = new Conn();
            String query = "SELECT * FROM customer WHERE Email = '"+Username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("Email"));
//                labelid.setText(rs.getString("Id"));
//                labelnumber.setText(rs.getString("Number"));
//                labelphone.setText(rs.getString("Phone"));
                //labelprice.setText(rs.getString("Price"));


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice =new JButton("Check Price");
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage =new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back =new JButton("Back");
        back.setBounds(340, 380, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(550, 50, 400, 300);
        add(image);

        setVisible(true);
    }
    public static void main(String[] args) {
        new BookPackage("divya");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")){
                cost+= 12000;

            } else if (pack.equals("Silver Package")) {
                cost+= 24000;
            }
            else if (pack.equals("Bronze Package")) {
                cost+= 32000;
            }

            int persons = Integer.parseInt((tfpersons.getText()));
            cost *= persons;
            labelprice.setText("Rs"+cost);

        } else if (e.getSource() == bookpackage) {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookpackage VALUES ('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
}
