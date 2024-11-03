import com.example.hltv.Match;
import com.example.hltv.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    // Подключение к базе данных PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/hltvdb";  // Проверьте это
    private static final String USER = "postgres";
    private static final String PASSWORD = "zazazin61";


    // Метод для подключения к базе данных
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Успешное подключение к базе данных PostgreSQL.");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        }
        return conn;
    }

    // Метод для получения списка матчей из базы данных
    public List<Match> getMatches(Connection conn) throws SQLException {
        List<Match> matches = new ArrayList<>();
        String query = "SELECT team1, team2, match_time, event FROM matches";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String team1 = rs.getString("team1");
                String team2 = rs.getString("team2");
                Timestamp matchTime = rs.getTimestamp("match_time");
                String event = rs.getString("event");

                Match match = new Match(team1, team2, matchTime.toLocalDateTime().toString(), event);
                matches.add(match);
            }
        }
        return matches;
    }

    // Метод для получения списка команд из базы данных
    public List<Team> getTeams(Connection conn) throws SQLException {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT team_name, rank, points FROM teams";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String teamName = rs.getString("team_name");
                int rank = rs.getInt("rank");
                String points = rs.getString("points");

                Team team = new Team(rank, teamName, points);
                teams.add(team);
            }
        }
        return teams;
    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        try (Connection conn = dbManager.connect()) {
            if (conn != null) {
                // Пример использования методов getMatches и getTeams
                List<Match> matches = dbManager.getMatches(conn);
                List<Team> teams = dbManager.getTeams(conn);

                System.out.println("Матчи:");
                for (Match match : matches) {
                    System.out.println(match);
                }

                System.out.println("\nКоманды:");
                for (Team team : teams) {
                    System.out.println(team);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
