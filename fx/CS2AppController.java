package fx;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.List;

public class CS2AppController {

    @FXML
    private ListView<String> matchListView;

    // Метод для загрузки матчей в ListView
    public void loadMatches(List<String> matches) {
        matchListView.getItems().addAll(matches);
    }
}
