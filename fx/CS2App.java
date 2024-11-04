package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CS2App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CS2App.fxml"));
            VBox root = loader.load();
            Scene scene = new Scene(root, 300, 200);
            scene.getStylesheets().add(getClass().getResource("/fxml/styles.css").toExternalForm());

            primaryStage.setTitle("CS2");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}