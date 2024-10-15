package com.md.gm.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import com.md.gm.Controllers.Client.ClientController;
import java.io.*;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink forgotPasswordLink;

    @FXML
    private Hyperlink joinNowLink;
    private final ClientController clientController = new ClientController();
    @FXML
    public void initialize() {
        // Log in button action
        loginButton.setOnAction(event -> onLogin());

        // Forgot password link action
        forgotPasswordLink.setOnAction(event -> onForgotPassword());

        // Join now link action
        joinNowLink.setOnAction(event -> onJoinNow());
    }

    private void onLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please enter both username and password.");
        } else if (username.equals("admin") && password.equals("admin")) {
            showAlert("Success", "Login successful!");
            // Proceed to the next screen
        } else if(clientController.validateCredentials(username, password)){
            showAlert("Success", "Login successful!");
            // Proceed to the next screen
        }else {
            showAlert("Error", "Invalid credentials. Please try again.");
        }
    }

    private void onForgotPassword() {
        showAlert("Password Recovery", "Redirecting to password recovery...");
        // Implement password recovery logic here
    }

    private void onJoinNow() {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Error", "Please enter both username and password.");
            } else {
                // Call the createUser method from ClientController
                String result = clientController.createUser(username, password);
                showAlert(result.contains("successfully") ? "Success" : "Error", result);
            }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
