package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class CS2App extends Application {
    Button button;

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/CS2App.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("/fxml/style.css").toExternalForm();
            scene.getStylesheets().add(css);
            primaryStage.setTitle("JavaFX App");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {launch(args);}
}
