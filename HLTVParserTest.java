import com.example.hltv.HLTVParser;
import com.example.hltv.Match;
import com.example.hltv.Team;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HLTVParserTest {

    private final DatabaseManager dbManager = new DatabaseManager();

    org.jsoup.Connection connection = Jsoup.connect("https://www.hltv.org/matches")
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36")
            .timeout(10000) // Увеличьте тайм-аут до 10 секунд
            .ignoreHttpErrors(true);


    @Test
    public void testParseUpcomingMatches() {
        HLTVParser parser = new HLTVParser();
        try (Connection conn = dbManager.connect()) {
            // Парсим матчи и загружаем их в базу данных
            parser.parseUpcomingMatches();

            // Получаем данные о матчах из базы данных
            List<Match> matches = dbManager.getMatches(conn);
            assertNotNull(matches, "Список матчей не должен быть null");
            assertTrue(matches.size() > 0, "Список матчей не должен быть пустым");

            // Проверка первого матча в списке
            Match firstMatch = matches.get(0);
            assertNotNull(firstMatch.getTeam1(), "Название первой команды не должно быть null");
            assertNotNull(firstMatch.getTeam2(), "Название второй команды не должно быть null");
            assertNotNull(firstMatch.getMatchTime(), "Время матча не должно быть null");
            assertNotNull(firstMatch.getEvent(), "Название события не должно быть null");

            System.out.println("Матчи успешно загружены в базу данных и прошли тесты.");
        } catch (IOException | SQLException e) {
            fail("Произошла ошибка при парсинге матчей или работе с базой данных: " + e.getMessage());
        }
    }

    @Test
    public void testParseTop20Teams() {
        HLTVParser parser = new HLTVParser();
        try (Connection conn = dbManager.connect()) {
            // Парсим команды и загружаем их в базу данных
            parser.parseTop20Teams();

            // Получаем данные о командах из базы данных
            List<Team> teams = dbManager.getTeams(conn);
            assertNotNull(teams, "Список команд не должен быть null");
            assertTrue(teams.size() > 0, "Список команд не должен быть пустым");

            // Проверка первой команды в списке
            Team firstTeam = teams.get(0);
            assertNotNull(firstTeam.getName(), "Название команды не должно быть null");
            assertTrue(firstTeam.getRank() > 0, "Ранг команды должен быть положительным числом");
            assertNotNull(firstTeam.getPoints(), "Очки команды не должны быть null");

            System.out.println("Команды успешно загружены в базу данных и прошли тесты.");
        } catch (IOException | SQLException e) {
            fail("Произошла ошибка при парсинге команд или работе с базой данных: " + e.getMessage());
        }
    }
}
