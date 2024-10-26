import java.util.List;

class CS2Service {
    private MatchParser matchParser;
    private Analytics analytics;

    public CS2Service(MatchParser matchParser, Analytics analytics) {
        this.matchParser = matchParser;
        this.analytics = analytics;
    }

    public void processMatches() {
        List<Match1> matches = matchParser.parseMatches();
        analytics.analyzeMatches(matches);
    }
}
