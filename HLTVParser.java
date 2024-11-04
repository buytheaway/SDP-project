import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HLTVParser {
    private static final String BASE_URL = "https://www.gosugamers.net/counterstrike";

    public List<MatchInterface> parseUpcomingMatches() throws IOException {
        List<MatchInterface> matches = new ArrayList<>();
        Document doc = Jsoup.connect(BASE_URL + "/matches").get();
        Elements matchElements = doc.select(".match-row"); // Adjust based on site HTML

        for (Element element : matchElements) {
            String team1 = element.select(".team1").text(); // Adjust based on site HTML
            String team2 = element.select(".team2").text();
            String matchTime = element.select(".match-time").text();
            String event = element.select(".event-name").text();

            matches.add(new MatchInterface(team1, team2, matchTime, event));
        }
        return matches;
    }
}
