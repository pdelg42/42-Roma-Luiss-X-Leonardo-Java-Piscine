package com.forData.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class Program {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            if (connection != null) {
                System.out.println("Connection ok.");
            } else {
                System.out .println("Connection refused.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
