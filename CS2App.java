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
        Label label = new Label("Добро пожаловать в CS2 Аналитику");
        root.getChildren().add(label);

        // Список для отображения матчей
        ListView<String> matchListView = new ListView<>();
        root.getChildren().add(matchListView);

        // Загружаем данные матчей и отображаем
        HLTVParseR parser = new HLTVParseR();
        List<Match> matches = parser.parseUpcomingMatches();
        for (Match match : matches) {
            matchListView.getItems().add(match.toString());
        }

        // Настройка сцены
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
