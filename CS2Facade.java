import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CS2Facade {
    private final HLTVParser hltvParser;
    private final DatabaseManager dbManager;

    public CS2Facade() {
        this.hltvParser = new HLTVParser();
        this.dbManager = new DatabaseManager();
    }

    public void updateMatchData() {
        try (Connection conn = dbManager.connect()) {
            if (conn != null) {
                dbManager.clearOldData(conn);
                List<MatchInterface> matches = hltvParser.parseUpcomingMatches();
                dbManager.insertMatchData(conn, matches);
                System.out.println("Match data updated successfully.");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error updating match data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CS2Facade facade = new CS2Facade();
        facade.updateMatchData();
    }
}
