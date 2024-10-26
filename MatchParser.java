import java.util.List;

interface MatchParser {
    List<Match1> parseMatches();
}

interface Analytics {
    void analyzeMatches(List<Match1> matches);
}

interface PlayerProfileManager {
    PlayerData getPlayerProfile(String playerId);
}
