package com.example.hltv;

// Модель данных для матча
public class Match {
    private String team1;
    private String team2;
    private String time;
    private String event;

    public Match(String team1, String team2, String time, String event) {
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
        this.event = event;
    }

    @Override
    public String toString() {
        return "Match: " + team1 + " vs " + team2 + " at " + time + " for " + event;
    }

    public String getTeam1() {
        return null;
    }

    public String getTeam2() {
        return null;
    }

    public String getMatchTime() {
        return null;
    }

    public String getEvent() {
        return null;
    }
}
