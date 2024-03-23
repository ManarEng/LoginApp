package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.utils.DatabaseUtils;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get a connection to the database
            connection = DatabaseUtils.getConnection();
            
            // Prepare SQL statement to retrieve all users
            String sql = "SELECT * FROM users";
            preparedStatement = connection.prepareStatement(sql);
            
            // Execute the query
            resultSet = preparedStatement.executeQuery();
            
            // Process the result set
            while (resultSet.next()) {
                // Retrieve user information from the result set
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                // You can retrieve other user attributes here if needed
                
                // Print user information
                System.out.println("Email: " + email + ", Password: " + password);
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging the exception
        } 
    }
}
