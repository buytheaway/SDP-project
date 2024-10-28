import java.time.LocalDateTime;

public class MatchParse {
    private String team1;
    private String team2;
    private LocalDateTime matchTime;
    private String event;

    public MatchParse(String team1, String team2, LocalDateTime matchTime, String event) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchTime = matchTime;
        this.event = event;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public LocalDateTime getMatchTime() {
        return matchTime;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "Match: " + team1 + " vs " + team2 + " at " + matchTime + " for " + event;
    }
}
