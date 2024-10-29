import java.util.HashMap;
import java.util.Map;


//хранения данных о игроках
class PlayerFlyweight {
    private static Map<String, PlayerData> players = new HashMap<>();

    public static PlayerData getPlayer(String playerId, String name, String team) {
        return players.computeIfAbsent(playerId, k -> new PlayerData(playerId, name, team));
    }
}

class PlayerData {
    private String playerId;
    private String name;
    private String team;

    public PlayerData(String playerId, String name, String team) {
        this.playerId = playerId;
        this.name = name;
        this.team = team;
    }

}
