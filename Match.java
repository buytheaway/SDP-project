public class Match {
    private final String team1;
    private final String team2;
    private final String matchTime;
    private final String event;

    public Match(String team1, String team2, String matchTime, String event) {
        this.team1 = team1;
        this.team2 = team2;
        this.matchTime = matchTime;
        this.event = event;
    }

    public String getTeam1() { return team1; }
    public String getTeam2() { return team2; }
    public String getMatchTime() { return matchTime; }
    public String getEvent() { return event; }
}
