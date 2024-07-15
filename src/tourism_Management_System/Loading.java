package tourism_Management_System;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread thread;
    JProgressBar bar;
    String Username;
    Loading(String Username){
        this.Username = Username;
        thread = new Thread(this);

        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel & Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(230, 130, 150, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel lblUsername = new JLabel("Welcome " + Username );
        lblUsername.setBounds(20, 310, 440, 40);
        lblUsername.setForeground(Color.RED);
        lblUsername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lblUsername);

        thread.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }

    @Override
    public void run() {
        try{
            for(int i=1; i<=101; i++ ){
                int max = bar.getMaximum();
                int value = bar.getValue();

                if(value < max) {
                    bar.setValue(bar.getValue() + 1);
                }
                else {
                    setVisible(false);
                    new Dashboard(Username);

                }
                Thread.sleep((30));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
