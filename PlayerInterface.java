public class PlayerInterface {
    private int id;
    private String playerName;
    private String teamName;
    private String position;

    // Constructor
    public PlayerInterface(int id, String playerName, String teamName, String position) {
        this.id = id;
        this.playerName = playerName;
        this.teamName = teamName;
        this.position = position;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getPosition() {
        return position;
    }
}
