package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import fx.CS2AppController;
public class CS2App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/CS2App.fxml"));
        primaryStage.setTitle("CS2 Analytics");
        primaryStage.setScene(root.getScene());
        primaryStage.show();

    }

    public static void main(String[] args) {launch(args);}
}
