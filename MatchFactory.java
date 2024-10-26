interface MatchFactory {
    Match1 createMatch();
    Player1 createPlayer(String playerId, String name, String team);
}

class BO1MatchFactory implements MatchFactory {
    @Override
    public Match1 createMatch() {
        return new BO1Match2();
    }

    @Override
    public Player1 createPlayer(String playerId, String name, String team) {
        return new Player1(playerId, name, team);
    }
}

class BO3MatchFactory implements MatchFactory {
    @Override
    public Match1 createMatch() {
        return new BO3Match2();
    }

    @Override
    public Player1 createPlayer(String playerId, String name, String team) {
        return new Player1(playerId, name, team);
    }
}

// Пример матчей разных типов
class BO1Match extends Match1 {
    public BO1Match() {
        super("BO1");
    }

    @Override
    public void start() {

    }
}

class BO3Match extends Match1 {
    public BO3Match() {
        super("BO3");
    }

    @Override
    public void start() {

    }
}

class Match {
    private String type;

    public Match(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public class TeamStats {
    }
}

class Player {
    private String playerId;
    private String name;
    private String team;

    public Player(String playerId, String name, String team) {
        this.playerId = playerId;
        this.name = name;
        this.team = team;
    }

    // Getters и другие методы
}
