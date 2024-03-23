// package com.example.utils;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class DatabaseUtils implements Config{
//     // Method to establish a connection to the database
//     public static Connection getConnection() throws SQLException {
//         try {
//             // Load the JDBC driver
//             Class.forName(JDBC_DRIVER);
//             // Establish the database connection
//             return DriverManager.getConnection(JDBC_URL, USERNAME , PASSWORD );
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//             throw new SQLException("JDBC driver not found", e);
//         }
//     }

//     // Method to close the database connection
//     public static void closeConnection(Connection connection) {
//         if (connection != null) {
//             try {
//                 connection.close();
//             } catch (SQLException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
