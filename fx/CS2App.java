package fxml;

import fxml.CS2AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CS2App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
<<<<<<< Updated upstream
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainMenu.fxml"));
            Scene mainMenuScene = new Scene(loader.load());
            CS2AppController controller = loader.getController();
            controller.setStage(primaryStage);
=======
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CS2App.fxml"));
            VBox root = loader.load();
            Scene scene = new Scene(root, 500, 700);
            scene.getStylesheets().add(getClass().getResource("/fxml/styles.css").toExternalForm());
>>>>>>> Stashed changes

            primaryStage.setTitle("CS2 Database Viewer");
            primaryStage.setScene(mainMenuScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
