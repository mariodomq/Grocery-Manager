package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SignUpController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Hyperlink loginLink;

    @FXML
    private void handleSignUp() {
        String email = emailField.getText();
        String password = passwordField.getText();
        
        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Email and password fields cannot be empty.");
        } else {
            // Place your sign-up logic here, e.g., storing user data
            showAlert("Success", "Account created successfully!");
        }
    }

    @FXML
    private void goToLogin() {
        try {
            // Code to navigate to Login screen
            // Assuming you have a method to change scenes, e.g., using a SceneManager or similar setup
            SceneManager.loadScene("Login.fxml"); // Replace with actual navigation logic
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Unable to navigate to login.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
