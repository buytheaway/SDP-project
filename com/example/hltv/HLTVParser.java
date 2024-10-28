package com.example.hltv;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HLTVParser {

    private static final String HLTV_URL_MATCHES = "https://www.hltv.org/matches";
    private static final String HLTV_URL_RANKING = "https://www.hltv.org/ranking/teams";

    // Метод для получения статистики команды
    public TeamStats parseTeamStats(String teamUrl) throws IOException {
        Document doc = Jsoup.connect(teamUrl).get();

        // Например, статистика на странице команды
        String teamName = doc.select(".profile-team-name").text();
        String winRate = doc.select(".team-stat-winrate .value").text();
        String totalMatches = doc.select(".team-stat-total-matches .value").text();

        // Возвращаем объект TeamStats с извлечёнными данными
        return new TeamStats(teamName, winRate, totalMatches);
    }

    // Метод для получения списка матчей
    public List<Match> parseUpcomingMatches() throws IOException {
        List<Match> matches = new ArrayList<>();
        Document doc = Jsoup.connect(HLTV_URL_MATCHES).get();

        Elements matchElements = doc.select(".upcomingMatch");
        for (Element matchElement : matchElements) {
            String team1 = matchElement.select(".team1 .team").text();
            String team2 = matchElement.select(".team2 .team").text();
            String matchTime = matchElement.select(".time").text();
            String event = matchElement.select(".event").text();

            Match match = new Match(team1, team2, matchTime, event);
            matches.add(match);
        }

        return matches;
    }

    // Метод для получения топ-20 команд
    public List<Team> parseTop20Teams() throws IOException {
        List<Team> teams = new ArrayList<>();
        Document doc = Jsoup.connect(HLTV_URL_RANKING).get();

        Elements teamElements = doc.select(".ranked-team");
        for (Element teamElement : teamElements) {
            String rank = teamElement.select(".position").text().replace("#", "");
            String teamName = teamElement.select(".teamLine a").text();
            String points = teamElement.select(".points").text();

            Team team = new Team(Integer.parseInt(rank), teamName, points);
            teams.add(team);
        }

        return teams;
    }
}

// Модель данных для статистики команды
class TeamStats {
    private String teamName;
    private String winRate;
    private String totalMatches;

    public TeamStats(String teamName, String winRate, String totalMatches) {
        this.teamName = teamName;
        this.winRate = winRate;
        this.totalMatches = totalMatches;
    }

    @Override
    public String toString() {
        return "Team: " + teamName + ", Win Rate: " + winRate + ", Total Matches: " + totalMatches;
    }
}

