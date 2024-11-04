import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HLTVParserTest {
    private final HLTVParser hltvParser = new HLTVParser();
    private final DatabaseManager dbManager = new DatabaseManager();

    @Test
    public void testParseUpcomingMatches() {
        HLTVParser parser = new HLTVParser();
        try {
            List<MatchInterface> matches = parser.parseUpcomingMatches();

            // Debugging: print the size and contents of the matches list
            System.out.println("Parsed matches size: " + matches.size());
            matches.forEach(System.out::println);

            assertNotNull(matches, "Matches list should not be null");
            assertTrue(matches.size() > 0, "Matches list should not be empty");
        } catch (IOException e) {
            fail("Error parsing matches: " + e.getMessage());
        }
    }


    @Test
    public void testDatabaseInsertMatches() {
        try (Connection conn = dbManager.connect()) {
            if (conn != null) {
                // Clear existing data before test
                dbManager.clearOldData(conn);

                // Parse matches and insert them into the database
                List<MatchInterface> matches = hltvParser.parseUpcomingMatches();
                dbManager.insertMatchData(conn, matches);

                // Verify the matches were inserted
                List<MatchInterface> retrievedMatches = dbManager.getMatches(conn);
                assertEquals(matches.size(), retrievedMatches.size(), "Inserted matches should match retrieved count");

                System.out.println("Database insert and retrieve test passed.");
            }
        } catch (SQLException | IOException e) {
            fail("Database test failed: " + e.getMessage());
        }
    }
}
