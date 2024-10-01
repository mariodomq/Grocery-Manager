package com.md.gm.Controllers.Client;

import java.sql.*;

public class ClientController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String DB_USERNAME = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = "your_password"; // Replace with your MySQL password

    public ClientController() {
    }

    // Method to validate user credentials from the database
    public boolean validateCredentials(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If this returns then it is valid
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    // Method to create a new user and store in the database
    public static String createUser(String username, String password) {
        // checks if user is taken
        String checkQuery = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                return "Username already exists. Try a different username.";
            }

            // Creates new user
            String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.executeUpdate();
                return "Account creation succesful!";
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return "Error creating account.";
        }
    }
}
