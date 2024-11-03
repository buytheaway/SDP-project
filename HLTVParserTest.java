import com.example.hltv.HLTVParser;
import com.example.hltv.Match;
import com.example.hltv.Team;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;

public class HLTVParserTest {

    @Test
    public void testParseUpcomingMatches() {
        HLTVParser parser = new HLTVParser();
        try {
            List<Match> matches = parser.parseUpcomingMatches();
            assertNotNull(matches, "Список матчей не должен быть null");
            assertTrue(matches.size() > 0, "Список матчей не должен быть пустым");

            // Проверка первого матча в списке
            Match firstMatch = matches.get(0);
            assertNotNull(firstMatch.getTeam1(), "Название первой команды не должно быть null");
            assertNotNull(firstMatch.getTeam2(), "Название второй команды не должно быть null");
            assertNotNull(firstMatch.getMatchTime(), "Время матча не должно быть null");
            assertNotNull(firstMatch.getEvent(), "Название события не должно быть null");

            System.out.println("Матчи успешно спарсены и прошли тесты.");
        } catch (IOException e) {
            fail("Произошла ошибка при парсинге матчей: " + e.getMessage());
        }
    }

    @Test
    public void testParseTop20Teams() {
        HLTVParser parser = new HLTVParser();
        try {
            List<Team> teams = parser.parseTop20Teams();
            assertNotNull(teams, "Список команд не должен быть null");
            assertTrue(teams.size() > 0, "Список команд не должен быть пустым");

            // Проверка первой команды в списке
            Team firstTeam = teams.get(0);
            assertNotNull(firstTeam.getName(), "Название команды не должно быть null");
            assertTrue(firstTeam.getRank() > 0, "Ранг команды должен быть положительным числом");
            assertNotNull(firstTeam.getPoints(), "Очки команды не должны быть null");

            System.out.println("Команды успешно спарсены и прошли тесты.");
        } catch (IOException e) {
            fail("Произошла ошибка при парсинге команд: " + e.getMessage());
        }
    }
}
