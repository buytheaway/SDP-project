// Модель данных для команды
public class Team {
    private int rank;
    private String name;
    private String points;

    public Team(int rank, String name, String points) {
        this.rank = rank;
        this.name = name;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Rank #" + rank + ": " + name + " (" + points + ")";
    }

    public String getName() {
        return null;
    }

    public int getRank() {
        return 0;
    }

    public String getPoints() {
        return null;
    }
}
