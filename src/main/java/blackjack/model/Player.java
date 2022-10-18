package blackjack.model;

public class Player {

    private String name;
    private int betAmounts;

    public Player(String name, int betAmounts) {
        this.name = name;
        this.betAmounts = betAmounts;
    }

    public String getName() {
        return name;
    }

    public int getBetAmounts() {
        return betAmounts;
    }
}
