package your.package;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ForgotPasswordController {

    @FXML
    private Label titleLabel;

    @FXML
    private Label emailPromptLabel;

    @FXML
    private TextField emailField;

    @FXML
    private Button sendButton;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private void handleSendButtonAction() {
        String email = emailField.getText();
        
        if (email.isEmpty()) {
            errorMessageLabel.setText("Please enter your email.");
            return;
        }
        
        // Replace this with actual email sending logic
        boolean emailSent = sendEmailWithPassword(email);
        
        if (emailSent) {
            errorMessageLabel.setText("Password sent to your email!");
        } else {
            errorMessageLabel.setText("Failed to send email. Please try again.");
        }
    }

    @FXML
    private void handleHyperlinkAction() {
        // Logic to navigate to the sign-up screen
        navigateToSignUpScreen();
    }

    private boolean sendEmailWithPassword(String email) {
        // Mocking the actual email sending function.
        // In a real project, you would implement email sending logic here.
        System.out.println("Sending password to: " + email);
        return true; // Return true to simulate success
    }

    private void navigateToSignUpScreen() {
        System.out.println("Navigating to Sign-Up Screen...");
        // Actual navigation code would go here (e.g., loading a new FXML for the sign-up screen)
    }
}
