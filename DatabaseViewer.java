import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseViewer {

    private static final String URL = "jdbc:postgresql://localhost:5432/hltvdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "zazazin61";

    public void displayDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("=== Matches ===");
            displayMatches(conn);

            System.out.println("\n=== Teams ===");
            displayTeams(conn);

            System.out.println("\n=== Players ===");
            displayPlayers(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayMatches(Connection conn) throws SQLException {
        String query = "SELECT * FROM matches ORDER BY match_time";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String team1 = rs.getString("team1");
                String team2 = rs.getString("team2");
                String matchTime = rs.getTimestamp("match_time").toString();
                String event = rs.getString("event");

                System.out.println("ID: " + id + ", " + team1 + " vs " + team2 + " at " + matchTime + " for " + event);
            }
        }
    }

    public void displayTeams(Connection conn) throws SQLException {
        String query = "SELECT * FROM teams ORDER BY rank";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String teamName = rs.getString("team_name");
                int rank = rs.getInt("rank");
                String points = rs.getString("points");

                System.out.println("ID: " + id + ", Rank #" + rank + ": " + teamName + " (" + points + ")");
            }
        }
    }

    public void displayPlayers(Connection conn) throws SQLException {
        String query = "SELECT players.id, players.player_name, teams.team_name, players.position " +
                "FROM players " +
                "LEFT JOIN teams ON players.team_id = teams.id " +
                "ORDER BY teams.rank ASC, players.position ASC";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String playerName = rs.getString("player_name");
                String teamName = rs.getString("team_name") != null ? rs.getString("team_name") : "No Team";
                String position = rs.getString("position") != null ? rs.getString("position") : "Unknown Position";

                System.out.println("#" + id + ", Player: " + playerName );
            }
        }
    }


    public static void main(String[] args) {
        DatabaseViewer viewer = new DatabaseViewer();
        viewer.displayDatabase();
    }
}
