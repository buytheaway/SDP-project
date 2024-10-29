package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CS2AppController {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private void handleButtonClick() {
        label.setText("Button clicked!");
    }
}
