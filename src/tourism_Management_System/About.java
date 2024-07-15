package tourism_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(600, 200, 500, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);

        String s = "we believe in the transformative power of travel. Whether you're a seasoned explorer or a first-time adventurer, our platform is designed to inspire and facilitate your journey into the world's most captivating destinations. From pristine beaches to bustling cities, from ancient wonders to modern marvels, we curate experiences that cater to every traveler's dreams.\n" +
                "\n" +
                "Explore Limitless Possibilities\n" +
                "\n" +
                "Discover a treasure trove of travel options tailored to suit your preferences. Navigate through our meticulously crafted itineraries that cater to solo travelers, couples, families, and groups. Whether you seek relaxation, cultural immersion, outdoor escapades, or culinary delights, our diverse array of tours ensures there's something for everyone.\n" +
                "\n" +
                "Why Choose Us?\n" +
                "\n" +
                "Expertly Curated Tours: Our team of travel experts scours the globe to handpick the finest experiences, ensuring every journey is filled with authenticity and wonder.\n" +
                "\n" +
                "Seamless Booking: With our user-friendly interface, booking your dream vacation is a breeze. Secure payments and instant confirmations guarantee peace of mind.\n" +
                "\n" +
                "Local Expertise: Benefit from insider knowledge and local insights provided by our network of experienced guides and partners in every destination.\n" +
                "\n" +
                "Tailored Experiences: Personalize your adventure with optional add-ons, private tours, and bespoke packages that cater to your unique interests and schedule.";

        TextArea area = new TextArea(s, 10,40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        back.addActionListener(this);
        add(back);


        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
