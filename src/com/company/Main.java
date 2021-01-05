package com.company;

import java.sql.*;

import static java.lang.Math.random;

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
            ResultSet rs = null;

            if (conn != null) {
                System.out.println("Connected");
                String queryInsert = "insert into users(user_id, username,password,fullname,email) values ('8','AAA','0000','ASSESSES','a@a.com')";
                String querySelectAll = "select * from users";
                String querySelectByUserID = "select * from users where user_id = 6";
                String queryUpdateByUserID = "update users set user_id = "+random() * (100 - 20 + 1)+"where user_id = 8";
                ps=conn.prepareStatement(queryUpdateByUserID);
                ps.executeUpdate();
                ps=conn.prepareStatement(queryInsert);
                ps.executeUpdate();
                System.out.println("Inserted");
                ps=conn.prepareStatement(querySelectAll);
                rs = ps.executeQuery();
                printSelectAll(rs);
                ps=conn.prepareStatement(querySelectByUserID);
                rs = ps.executeQuery();
                printSelectAll(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private static void printSelectAll(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        int columnCount = metaData.getColumnCount();
        System.out.println("****************************************************");
        while(rs.next()) {
            for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                Object object = rs.getObject(columnIndex);
                System.out.printf("%s, ", object == null ? "NULL" : object.toString());
            }
            System.out.printf("%n");}

    }
}
