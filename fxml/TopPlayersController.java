package fx;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TopPlayersController {

    @FXML
    private TableView<PlayerInterface> playersTable;

    @FXML
    private TableColumn<PlayerInterface, Integer> idColumn;

    @FXML
    private TableColumn<PlayerInterface, String> playerNameColumn;

    @FXML
    private TableColumn<PlayerInterface, String> teamNameColumn;

    @FXML
    private TableColumn<PlayerInterface, String> positionColumn;

    private DatabaseManager databaseManager;

    public void initialize() {
        databaseManager = new DatabaseManager();
        setupColumns();
        loadTopPlayersData();
    }

    private void setupColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
    }

    private void loadTopPlayersData() {
        try (Connection conn = databaseManager.connect()) {
            List<PlayerInterface> players = databaseManager.getTopPlayers(conn);
            playersTable.getItems().addAll(players);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
