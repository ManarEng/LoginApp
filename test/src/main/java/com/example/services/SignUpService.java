// package com.example.services;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// import com.example.models.User;

// public class SignUpService {

//     public boolean registerUser(User user) {
//         Connection connection = null;
//         PreparedStatement preparedStatement ;

//         try {
//             // Prepare SQL statement to insert user information into the database
//             String sql2 = "INSERT INTO users (firstname, lastname, email, password, phone_number, gender) VALUES (?, ?, ?, ?, ?, ?)";
//             preparedStatement = connection.prepareStatement(sql2);
//             preparedStatement.setString(1, user.getFirstname());
//             preparedStatement.setString(2, user.getLastname());
//             preparedStatement.setString(3, user.getEmail());           
//             preparedStatement.setString(4, user.getPassword());
//             preparedStatement.setString(5, user.getPhoneNumber());
//             preparedStatement.setString(6, user.getGender());

//             // Execute the query
//             int rowsAffected = preparedStatement.executeUpdate();

//             return true;
            
//         } catch (SQLException e) {
//             e.printStackTrace(); // Consider logging the exception
//             return false; // Registration failed due to database error
//         }
//     }
// }
