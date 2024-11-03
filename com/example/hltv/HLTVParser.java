package com.example.hltv;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;

public class HLTVParser {

    private static final String HLTV_URL_MATCHES = "https://www.hltv.org/matches";
    private static final String HLTV_URL_RANKING = "https://www.hltv.org/ranking/teams";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36";

    // Настройки прокси
    private static final String PROXY_HOST = "192.168.1.152"; // Замените на IP адрес реального прокси
    private static final int PROXY_PORT = 3356; // Замените на порт прокси

    private static final String PROXY_USERNAME = "your_username"; // Имя пользователя для прокси (если требуется)
    private static final String PROXY_PASSWORD = "your_password"; // Пароль для прокси (если требуется)

    // Настройка аутентификации для прокси
    static {
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(PROXY_USERNAME, PROXY_PASSWORD.toCharArray());
            }
        });
    }

    // Метод для получения HTML-документа с прокси и User-Agent
    private Document fetchDocumentWithProxy(String url) throws IOException {
        return Jsoup.connect(url)
                .userAgent(USER_AGENT)
                .proxy(PROXY_HOST, PROXY_PORT) // Установка прокси
                .timeout(10000) // Тайм-аут 10 секунд
                .get();
    }

    // Метод для добавления задержки между запросами
    private void delay() {
        try {
            Thread.sleep(2000); // Задержка 2 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Метод для парсинга предстоящих матчей с использованием прокси
    public List<Match> parseUpcomingMatches() throws IOException {
        List<Match> matches = new ArrayList<>();
        Document doc = fetchDocumentWithProxy(HLTV_URL_MATCHES);
        delay(); // Добавляем задержку перед обработкой данных

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

    // Метод для парсинга топ-20 команд с использованием прокси
    public List<Team> parseTop20Teams() throws IOException {
        List<Team> teams = new ArrayList<>();
        Document doc = fetchDocumentWithProxy(HLTV_URL_RANKING);
        delay(); // Добавляем задержку перед обработкой данных

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
