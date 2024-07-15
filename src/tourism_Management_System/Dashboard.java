package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Dashboard extends JFrame implements ActionListener {

    String Username;
    JButton addpersonalDetails, viewpersonalDetails, updatepersonalDetails, checkpackages, bookpackage,
            viewpackages, viewhotels, destinations, bookhotel, viewbookedhotels, payments, calculator, notepad, about;

    Dashboard(String Username){
        this.Username = Username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0, 0, 1600,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);
        p1.add(image);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0, 65, 300,900);
        add(p2);

        addpersonalDetails = new JButton("Add Personal Details");
        addpersonalDetails.setBounds(0, 0, 300, 50);
        addpersonalDetails.setBackground(new Color(0,0, 102));
        addpersonalDetails.setForeground(Color.WHITE);
        addpersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addpersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addpersonalDetails.addActionListener(this);
        p2.add(addpersonalDetails);

        updatepersonalDetails = new JButton("Update Personal Details");
        updatepersonalDetails.setBounds(0, 50, 300, 50);
        updatepersonalDetails.setBackground(new Color(0,0, 102));
        updatepersonalDetails.setForeground(Color.WHITE);
        updatepersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatepersonalDetails.setMargin(new Insets(0, 0, 0, 30));
        updatepersonalDetails.addActionListener(this);
        p2.add(updatepersonalDetails);

        viewpersonalDetails = new JButton("View Details");
        viewpersonalDetails.setBounds(0, 100, 300, 50);
        viewpersonalDetails.setBackground(new Color(0,0, 102));
        viewpersonalDetails.setForeground(Color.WHITE);
        viewpersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpersonalDetails.setMargin(new Insets(0, 0, 0, 130));
        viewpersonalDetails.addActionListener(this);
        p2.add(viewpersonalDetails);

        JButton deletepersonalDetails = new JButton("Delete Personal Details");
        deletepersonalDetails.setBounds(0, 150, 300, 50);
        deletepersonalDetails.setBackground(new Color(0,0, 102));
        deletepersonalDetails.setForeground(Color.WHITE);
        deletepersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletepersonalDetails.setMargin(new Insets(0, 0, 0, 40));
        p2.add(deletepersonalDetails);

        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0, 200, 300, 50);
        checkpackages.setBackground(new Color(0,0, 102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackage = new JButton("Book Packages");
        bookpackage.setBounds(0, 250, 300, 50);
        bookpackage.setBackground(new Color(0,0, 102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 120));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackages = new JButton("View Packages");
        viewpackages.setBounds(0, 300, 300, 50);
        viewpackages.setBackground(new Color(0,0, 102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackages.setMargin(new Insets(0, 0, 0, 120));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 350, 300, 50);
        viewhotels.setBackground(new Color(0,0, 102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 140));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0, 400, 300, 50);
        bookhotel.setBackground(new Color(0,0, 102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0, 0, 0, 150));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

        viewbookedhotels = new JButton("View Booked Hotels");
        viewbookedhotels.setBounds(0, 450, 300, 50);
        viewbookedhotels.setBackground(new Color(0,0, 102));
        viewbookedhotels.setForeground(Color.WHITE);
        viewbookedhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhotels.setMargin(new Insets(0, 0, 0, 70));
        viewbookedhotels.addActionListener(this);
        p2.add(viewbookedhotels);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 500, 300, 50);
        destinations.setBackground(new Color(0,0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 135));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0, 550, 300, 50);
        payments.setBackground(new Color(0,0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 155));
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 600, 300, 50);
        calculator.setBackground(new Color(0,0, 102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0, 0, 0, 155));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 650, 300, 50);
        notepad.setBackground(new Color(0,0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 160));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 700, 300, 50);
        about.setBackground(new Color(0,0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 175));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel image1  = new JLabel(i6);
        image1.setBounds(0, 0, 1650, 1000);
        add(image1);

        JLabel text = new JLabel("Travel & Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 55));
        image1.add(text);



        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addpersonalDetails){
            new AddCustomer(Username);

        } else if (e.getSource() == viewpersonalDetails) {
            new ViewCustomer(Username);

        }
        else if (e.getSource() == updatepersonalDetails) {
            new UpdateCustomer(Username);

        }
        else if (e.getSource() == checkpackages) {
            new CheckPackage();

        }
        else if (e.getSource() == bookpackage) {
            new BookPackage(Username);

        }
        else if (e.getSource() == viewpackages) {
            new ViewPackage(Username);

        }
        else if (e.getSource() == viewhotels) {
            new CheckHotels();

        }
        else if (e.getSource() == destinations) {
            new Destinations();

        }
        else if (e.getSource() == bookhotel) {
            new BookHotel(Username);

        }
        else if (e.getSource() == viewbookedhotels) {
            new ViewBookedhotel(Username);

        }
        else if (e.getSource() == payments) {
            new Payment();

        }
        else if (e.getSource() == calculator) {
            try{
                Runtime .getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        else if (e.getSource() == notepad) {
            try{
                Runtime .getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        else if (e.getSource() == about) {
            new About();

        }

    }
}
