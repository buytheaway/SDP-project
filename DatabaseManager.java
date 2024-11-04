import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/hltvdb"; // Update with your DB name
    private static final String USER = "postgres"; // Update with your DB user
    private static final String PASSWORD = "zazazin61"; // Update with your DB password

    // Method to connect to the database
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to PostgreSQL database successfully.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    // Method to clear old match data before inserting new data
    public void clearOldData(Connection conn) throws SQLException {
        String query = "DELETE FROM matches";
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("Old match data cleared.");
        }
    }

    // Method to insert parsed match data into the database
    public void insertMatchData(Connection conn, List<MatchInterface> matches) throws SQLException {
        String query = "INSERT INTO matches (team1, team2, match_time, event) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            for (MatchInterface match : matches) {
                pstmt.setString(1, match.getTeam1());
                pstmt.setString(2, match.getTeam2());
                pstmt.setTimestamp(3, Timestamp.valueOf(match.getMatchTime())); // assuming matchTime is LocalDateTime
                pstmt.setString(4, match.getEvent());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            System.out.println("New match data inserted.");
        }
    }

    // Method to retrieve matches from the database
    public List<MatchInterface> getMatches(Connection conn) throws SQLException {
        List<MatchInterface> matches = new ArrayList<>();
        String query = "SELECT team1, team2, match_time, event FROM matches";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String team1 = rs.getString("team1");
                String team2 = rs.getString("team2");
                Timestamp matchTime = rs.getTimestamp("match_time");
                String event = rs.getString("event");

                MatchInterface match = new MatchInterface(team1, team2, matchTime.toLocalDateTime().toString(), event);
                matches.add(match);
            }
        }
        return matches;
    }
}