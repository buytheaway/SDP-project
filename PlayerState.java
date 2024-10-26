interface PlayerState {
    void play(Player1 player);
}

class AttackingState implements PlayerState {
    @Override
    public void play(Player1 player) {
        System.out.println(player.getName() + " атакует.");
    }
}

class DefendingState implements PlayerState {
    @Override
    public void play(Player1 player) {
        System.out.println(player.getName() + " защищается.");
    }
}

class Player1 {
    private String name;
    private PlayerState state;

    public Player1(String playerId, String s, String name) {
        this.name = name;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void play() {
        state.play(this);
    }

    public String getName() {
        return name;
    }
}
