package model.player;

import model.card.Cards;
import model.card.Deck;

abstract public class User {

    protected final Cards cards = new Cards();

    public Cards getCards() {
        return cards;
    }

    public void draw() {
        cards.add(Deck.draw());
    }

    public boolean isBurst() {
        return cards.isBurst();
    }

    public int cardSum() {
        return cards.sumWithACard();
    }
}
