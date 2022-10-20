package blackjack.model.player;

import blackjack.model.card.Cards;

public class Dealer {

    private static final int INITIAL_CARD_COUNT = 1;

    private final int money = 0;
    private final Cards cards = new Cards(INITIAL_CARD_COUNT);

    public Cards getCards() {
        return cards;
    }
}
