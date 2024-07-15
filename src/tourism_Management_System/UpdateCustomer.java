package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



    public class UpdateCustomer extends JFrame implements ActionListener {


        JComboBox comboid;
        JTextField tfnumber, tfcountry, tfaddress, tfphone, tfemail, tfid, tfgender , labelusername, labelname;
        JRadioButton rmale, rfemale;
        JButton add, back;

        UpdateCustomer(String Username){
            setBounds(500, 200, 850, 550);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);

            JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
            text.setBounds(50, 0, 300, 25);
            text.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(text);

            JLabel lblusername = new JLabel("Email Id");
            lblusername.setBounds(30, 50, 150, 25);
            add(lblusername);

            labelusername = new JTextField();
            labelusername.setBounds(220, 50, 150, 25);
            add(labelusername);

            JLabel lblid = new JLabel("Verification Id Type");
            lblid.setBounds(30, 90, 150, 25);
            add(lblid);

            tfid = new JTextField();
            tfid.setBounds(220, 90, 150, 25);
            add(tfid);

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

            tfgender = new JTextField();
            tfgender.setBounds(220, 210, 150, 25);
            add(tfgender);

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

//            JLabel lblemail= new JLabel("Email");
//            lblemail.setBounds(30, 370, 150, 25);
//            add(lblemail);
//
//            tfemail = new JTextField();
//            tfemail.setBounds(220, 370, 150, 25);
//            add(tfemail);

            add =new JButton("Update");
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

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/update.png"));
            Image i2 = i1.getImage().getScaledInstance(330, 300, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image  = new JLabel(i3);
            image.setBounds(400, 100, 400, 300);
            add(image);

            try {
                Conn c = new Conn();
                ResultSet rs =c.s.executeQuery("SELECT * FROM customer WHERE Email = '"+Username+"'");
                while (rs.next()){
                    labelusername.setText(rs.getString("Email"));
                    labelname.setText(rs.getString("Name"));
                    tfid.setText(rs.getString("Id"));
                    tfnumber.setText(rs.getString("Number"));
                    tfgender.setText(rs.getString("Gender"));
                    tfcountry.setText(rs.getString("Country"));
                    tfaddress.setText(rs.getString("Address"));
                    tfphone.setText(rs.getString("Phone"));
                    //tfemail.setText(rs.getString("Email"));

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }

            setVisible(true);
        }
        public static void main(String[] args) {
            new UpdateCustomer("");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== add){
                String Username = labelusername.getText();
                String Id = tfid.getText();
                String Number = tfnumber.getText();
                String Name = labelname.getText();
                String Gender = tfgender.getText();
                String Country = tfcountry.getText();
                String Address = tfaddress.getText();
                String Phone= tfphone.getText();
                String Email = tfemail.getText();

                try{
                    Conn c = new Conn();
                    String query = "Update customer SET Email = '"+Username+"', Id = '"+Id+"', Number = '"+Number+"', Name = '"+Name+"', Gender = '"+Gender+"',Country = '"+Country+"', Address = '"+Address+"', Phone = '"+Phone+"'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
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


