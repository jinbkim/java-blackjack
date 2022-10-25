package model.player;

public class Player extends User {

    private final String name;
    private final int betMoney;

    public Player(String name, int betMoney) {
        this.name = name;
        this.betMoney = betMoney;
    }

    public String getName() {
        return name;
    }
}
