package tourism_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelManagementSystem", "root", "@divya123");
            s = c.createStatement();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {


    }

}