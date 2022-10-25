package model.card;

import view.InputView;

public class Player extends User {

    private final String name;
    private final int betMoney;

    public Player(String name, int betMoney) {
        this.name = name;
        this.betMoney = betMoney;
    }

    public void drawCard() {
        InputView.printRequestDrawCard(name);
    }

    public String getName() {
        return name;
    }
}
