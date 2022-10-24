package model.card;

public class Player {

    private final String name;
    private final int betMoney;
    private final Cards cards = new Cards();

    public Player(String name, int betMoney) {
        this.name = name;
        this.betMoney = betMoney;
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }
}
