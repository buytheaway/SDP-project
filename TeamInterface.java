public class TeamInterface {
    private int id;
    private String teamName;
    private int rank;
    private String points;

    // Constructor
    public TeamInterface(int id, String teamName, int rank, String points) {
        this.id = id;
        this.teamName = teamName;
        this.rank = rank;
        this.points = points;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getRank() {
        return rank;
    }

    public String getPoints() {
        return points;
    }
}
