package com.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.models.User;

public class LoginService {

     Connection connection;
     PreparedStatement preparedStatement ;
     User user;


     public LoginService(Connection connection){       
        this.connection=connection;
    }

    public User authenticateUser(String email, String password) {
   
        try {
            
            // Prepare SQL statement to retrieve user information by email and password
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                  resultSet.getString("firstname"),
                  resultSet.getString("lastname"),
                  resultSet.getString("email"),
                  resultSet.getString("password"),
                  resultSet.getString("phone_number"),
                  resultSet.getString("gender"));
                 
            }
            
            // If a user with the given email and password is found, return true
            return user;

            
            
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging the exception
            return null; // Authentication failed due to database error
        }
    }
    
    
    public boolean registerUser(User user)  {
        
        try {
            // Prepare SQL statement to insert user information into the database
            String sql = "INSERT INTO users (firstname, lastname, email, password, phone_number, gender) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());           
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getGender());

             // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

             return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        

       


    }


}
