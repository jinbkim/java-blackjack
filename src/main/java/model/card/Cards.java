package model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cards {

    private static final int INITIAL_CARD_COUNT = 2;
    private static final String CARD_JOIN_DELIMITER = ", ";

    private final List<Card> cards = new ArrayList<>();

    public Cards() {
        IntStream.range(0, INITIAL_CARD_COUNT)
            .forEach(i -> cards.add(Deck.draw()));
    }

    public void add(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.stream()
            .map(card -> card.toString())
            .collect(Collectors.joining(CARD_JOIN_DELIMITER));
    }

    public List<Card> get() {
        return cards;
    }
}
