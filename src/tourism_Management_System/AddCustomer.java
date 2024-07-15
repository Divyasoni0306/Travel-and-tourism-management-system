package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {


    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail, labelusername, labelname;
    JRadioButton rmale, rfemale;
    JButton add, back;

    AddCustomer(String Username){
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Email Id");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JTextField();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);


        JLabel lblid = new JLabel("Verification Id Type");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox(new String[] {"Passport", "Aadhaar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber= new JLabel("Verification Id Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JTextField();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry= new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

//        JLabel lblemail= new JLabel("Email");
//        lblemail.setBounds(30, 370, 150, 25);
//        add(lblemail);
//
//        tfemail = new JTextField();
//        tfemail.setBounds(220, 370, 150, 25);
//        add(tfemail);

        add =new JButton("Add");
        add.setBounds(70, 430, 100, 50);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back =new JButton("Back");
        back.setBounds(220, 430, 100, 50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("SELECT * FROM account WHERE Email = '"+Username+"'");
            while (rs.next()){
                labelusername.setText(rs.getString("Email"));
                labelname.setText(rs.getString("Name"));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new AddCustomer("divya");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== add){
            String Username = labelusername.getText();
            String Id = (String) comboid.getSelectedItem();
            String Number = tfnumber.getText();
            String Name = labelname.getText();
            String Gender = null;
            if (rfemale.isSelected()){
                Gender = "Female";
            }
            else if (rmale.isSelected()){
                Gender = "Male";
            }
            String Country = tfcountry.getText();
            String Address = tfaddress.getText();
            String Phone= tfphone.getText();
            //String Email = tfemail.getText();

            try{
                Conn c = new Conn();
                String query = "INSERT INTO  customer Values('"+Username+"', '"+Id+"', '"+Number+"', '"+Name+"', '"+Gender+"','"+Country+"', '"+Address+"', '"+Phone+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }
}
