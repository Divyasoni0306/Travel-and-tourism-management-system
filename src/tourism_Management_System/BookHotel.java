package tourism_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookHotel extends JFrame implements ActionListener {
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays , labelusername, labelid, labelnumber, labelphone, labelprice;
    String Username;
    JLabel lblusername ;
    JButton checkprice , back , bookpackage;

    BookHotel(String Username){
        this.Username = Username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK Hotel");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        lblusername = new JLabel("Email");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JTextField();
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40, 120, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250, 120, 200,20);
        add(chotel);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM hotel");
            while(rs.next()){
                chotel.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons ");
        lblpersons.setBounds(40, 170, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 170, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of Days ");
        lbldays.setBounds(40, 220, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 220, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC / Non-AC ");
        lblac.setBounds(40, 270, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 270, 200,20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 320, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 320, 200,20);
        add(cfood);

//        JLabel lblid = new JLabel("Id");
//        lblid.setBounds(40, 310, 150, 20);
//        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblid);
//
//        labelid = new JTextField();
//        labelid.setBounds(250, 310, 200, 25);
//        add(labelid);

//        JLabel lblnumber = new JLabel("Number");
//        lblnumber.setBounds(40, 350, 150, 25);
//        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblnumber);
//
//        labelnumber = new JTextField();
//        labelnumber.setBounds(250, 350, 150, 25);
//        add(labelnumber);
//
//        JLabel lblphone = new JLabel("Phone");
//        lblphone.setBounds(40, 390, 150, 25);
//        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblphone);
//
//        labelphone = new JTextField();
//        labelphone.setBounds(250, 390, 150, 25);
//        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 370, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labelprice = new JTextField();
        labelprice.setBounds(250, 370, 150, 25);
        add(labelprice);


        try {
            Conn c = new Conn();
            String query = "SELECT * FROM customer WHERE Email = '"+Username+"' ";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("Email"));
                //labelid.setText(rs.getString("Id"));
                //labelnumber.setText(rs.getString("Number"));
                //labelphone.setText(rs.getString("Phone"));
                //labelprice.setText(rs.getString("Price"));


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice =new JButton("Check Price");
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage =new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back =new JButton("Back");
        back.setBounds(340, 490, 120, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(500, 50, 600, 400);
        add(image);

        setVisible(true);
    }
    public static void main(String[] args) {
        new BookHotel("divya");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkprice){
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("SELECT * FROM hotel WHERE Name ='" + chotel.getSelectedItem() + "'");
                while (rs.next()){
                    int cost = Integer.parseInt(rs.getString("Costperperson"));
                    int food = Integer.parseInt(rs.getString("Foodincluded"));
                    int ac = Integer.parseInt(rs.getString("Acroom"));

                    int persons = Integer.parseInt((tfpersons.getText()));
                    int days = Integer.parseInt((tfpersons.getText()));

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();

                    if (persons * days >0 ){
                        int total =0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total+= cost;
                        total+= total * persons * days;
                        labelprice.setText("Rs "+total);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }


            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == bookpackage) {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookhotel VALUES ('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
}
