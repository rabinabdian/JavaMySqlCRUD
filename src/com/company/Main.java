package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "admin";
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        try {

            Connection conn = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement ps=null;

            if (conn != null) {
                System.out.println("Connected");
                String query = "insert into users(user_id, username,password,fullname,email) values ('1','AAA','0000','ASSESSES','a@a.com')";
                ps=conn.prepareStatement(query);
                ps.executeUpdate();
                System.out.println("Updated");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
