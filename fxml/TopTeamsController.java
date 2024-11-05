package fx;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TopTeamsController {

    @FXML
    private TableView<TeamInterface> teamsTable;

    @FXML
    private TableColumn<TeamInterface, Integer> idColumn;

    @FXML
    private TableColumn<TeamInterface, String> teamNameColumn;

    @FXML
    private TableColumn<TeamInterface, Integer> rankColumn;

    @FXML
    private TableColumn<TeamInterface, String> pointsColumn;

    private DatabaseManager databaseManager;

    public void initialize() {
        databaseManager = new DatabaseManager();
        setupColumns();
        loadTopTeamsData();
    }

    private void setupColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        teamNameColumn.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
    }

    private void loadTopTeamsData() {
        try (Connection conn = databaseManager.connect()) {
            List<TeamInterface> teams = databaseManager.getTopTeams(conn);
            teamsTable.getItems().addAll(teams);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
