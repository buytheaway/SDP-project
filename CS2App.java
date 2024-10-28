import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class CS2App extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CS2 Analytics");

        VBox root = new VBox();
        Label label = new Label("Welcome to CS2 Analytics");
        root.getChildren().add(label);

        // ListView to display matches
        ListView<String> matchListView = new ListView<>();
        root.getChildren().add(matchListView);

        // Load and display match data
        HLTVParseR parser = new HLTVParseR();
        List<Match> matches = parser.parseUpcomingMatches();
        if (matches != null && !matches.isEmpty()) {
            for (Match match : matches) {
                matchListView.getItems().add(match.toString());
            }
        } else {
            System.out.println("No matches found to display.");
        }

        // Set up scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
