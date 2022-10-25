package model.player;

import model.card.Cards;
import model.card.Deck;

abstract public class User {

    private static final int TWENTY_ONE = 21;

    protected Cards cards = new Cards();
    private int money = 0;

    public void draw() {
        cards.add(Deck.draw());
    }

    public boolean isBurst() {
        return cardSum() > TWENTY_ONE;
    }

    public boolean isSum21() {
        return cardSum() == TWENTY_ONE;
    }

    public int cardSum() {
        return cards.sumWithACard();
    }

    public void winMoney(int money) {
        this.money += money;
    }

    public void loseMoney(int money) {
        this.money -= money;
    }

    public Cards getCards() {
        return cards;
    }

    public int getMoney() {
        return money;
    }
}
