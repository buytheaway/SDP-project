class MatchService {
    public void startMatch(Match1 match) {
        System.out.println("Начат матч типа: " + match.getType());
        match.start();
    }
}

abstract class Match1 {
    private String type;

    public Match1(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public abstract void start();
}

class BO1Match2 extends Match1 {
    public BO1Match2() {
        super("BO1");
    }

    @Override
    public void start() {
        System.out.println("Начат матч BO1");
    }
}

class BO3Match2 extends Match1 {
    public BO3Match2() {
        super("BO3");
    }

    @Override
    public void start() {
        System.out.println("Начат матч BO3");
    }
}

