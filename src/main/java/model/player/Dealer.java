package model.player;

import model.card.Card;

public class Dealer extends User {

    public Card getCardOne() {
        return cards.get()
            .get(0);
    }
}
