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
<<<<<<< HEAD
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CS2App.fxml"));
        primaryStage.setTitle("CS2 Analytics");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
=======
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
>>>>>>> db20e1879de484eec5c6b257a5cb826f18e0d504
    }


    public static void main(String[] args) {launch(args);}
}
