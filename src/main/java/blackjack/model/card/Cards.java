package blackjack.model.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private static final int INITIAL_CARD_COUNT = 2;

    private List<Card> cards = new ArrayList<>();

    public Cards() {
        for (int i = 0; i < INITIAL_CARD_COUNT; i++) {
            cards.add(CardCollection.draw());
        }
    }
}
