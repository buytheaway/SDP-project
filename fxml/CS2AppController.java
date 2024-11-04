package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CS2AppController {

    @FXML
    private Label messageLabel;

    @FXML
    private TextField inputField;

    @FXML
    private Button submitButton;

    @FXML
    private void handleSubmitButtonAction() {
        String userInput = inputField.getText();
        messageLabel.setText("Hello, " + userInput + "!");
    }
}
