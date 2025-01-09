package com.tut.db;


import com.tut.db.util.Printable;
import com.tut.db.util.PrintableFactory;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // Printable object(improved Console object)
        Printable printable = PrintableFactory.getPrintable();

        // MySQL JDBC url is of form : jdbc:mysql://[SERVER]:[PORT]/[DATABASE]
        String url = "jdbc:mysql://localhost:3306/universitate";

        // MySQL Database user username (hidden for obvious reasons)
        String username = Config.getProperty("MYSQL_USERNAME");

        // MySQL Database user password (same as before)
        String password = Config.getProperty("MYSQL_PASSWORD");


        try {

            // Registering the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Attempting connection
            // NOTE: we do need the registered driver(the MySQL JDBC driver) to make the connection
            Connection connection = DriverManager.getConnection(url,
                    username, password);

            // New query statement
            Statement statement = connection.createStatement();

            // Executing a query
            ResultSet result = statement.executeQuery("SELECT * FROM student");

            // Access column definitions to get the number of columns
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Fixed width
            int width = 17;

            // Print the table headings with a fixed width
            for(int i = 1; i<= columnCount; i++){
                String columnLabel = metaData.getColumnLabel(i);
                printable.fixedPrint(columnLabel, width, ' ');
            }
            printable.print("\n");
            printable.fixedPrint("", width*columnCount, '-');
            printable.print("\n");

            // Print the query results with a fixed width
            while(result.next()){
                for(int i = 1; i <= columnCount; i++){
                    String columnValue = result.getString(i);
                    printable.fixedPrint(columnValue, width, ' ');
                }
                printable.print("\n");
            }
            //Close the connection
            connection.close();
        }
        catch(Exception ex){
            printable.print("Exception: " + ex.getMessage());
        }
    }
}