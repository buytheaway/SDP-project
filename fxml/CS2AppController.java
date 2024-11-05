package fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CS2AppController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void showTopTeams() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TopTeamsView.fxml"));
        stage.setScene(new Scene(loader.load()));
    }

    @FXML
    private void showTopPlayers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TopPlayersView.fxml"));
        stage.setScene(new Scene(loader.load()));
    }
}
