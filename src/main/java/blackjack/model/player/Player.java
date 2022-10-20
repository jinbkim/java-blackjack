package blackjack.model.player;

import blackjack.model.card.Cards;

public class Player {

    private final String name;
    private int money;
    private Cards cards = new Cards();

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}
