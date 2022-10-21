package blackjack.model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    private static final String CARD_NAME_JOIN_DEL = ", ";

    private List<Card> cards = new ArrayList<>();

    public Cards(int initialCardCount) {
        for (int i = 0; i < initialCardCount; i++) {
            cards.add(CardCollection.draw());
        }
    }

    public void add(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.stream()
            .map(card -> card.toString())
            .collect(Collectors.joining(CARD_NAME_JOIN_DEL));
    }
}
