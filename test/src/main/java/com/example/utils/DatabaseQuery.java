// package com.example.utils;


// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// public class DatabaseQuery {

//     public static void main(String[] args) {
//         // Obtain database connection
//         try (Connection connection = DatabaseUtils.getConnection()) {
//             if (connection != null) {
//                 System.out.println("Database connection successful!");
//                 PreparedStatement preparedStatement ;


//                 //String query = "INSERT INTO user_accounts (email, password, first_name, last_name, username) VALUES (?, ?, ?, ?, ?)";
//                 //String deleteString = "DELETE FROM user_accounts ";
//                 // PreparedStatement statement = connection.prepareStatement(query);
//                 //     statement.setString(1, "oumaima.nou@example.com");
//                 //     statement.setString(2, "hello123");
//                 //     statement.setString(3, "Oumaima");
//                 //     statement.setString(4, "Nouini");
//                 //     statement.setString(5, "Oumnou");
        
//                  //     int rowsInserted = statement.executeUpdate();

//                  String sql = "INSERT INTO users (firstname, lastname, email, password, phone_number, gender) VALUES (?, ?, ?, ?, ?, ?)";
//                  preparedStatement = connection.prepareStatement(sql);
//                  preparedStatement.setString(1, "user.getFirstname()");
//                  preparedStatement.setString(2, "user.getLastname()");
//                  preparedStatement.setString(3, "user.getEmail()");           
//                  preparedStatement.setString(4, "user.getPassword()");
//                  preparedStatement.setString(5," user.get");
//                  preparedStatement.setString(6, "user)");
     
//                  // Execute the query
//                  int rowsAffected = preparedStatement.executeUpdate();

               
             

                    
//                 }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         }}



