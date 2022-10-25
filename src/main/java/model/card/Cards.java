package model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cards {

    private static final int INITIAL_CARD_COUNT = 2;
    private static final String CARD_JOIN_DELIMITER = ", ";
    private static final String A_CARD = "A";
    private static final int BURST_LEVEL = 21;
    private static final int A_CARD_SCORE_MIN = 1;
    private static final int A_CARD_SCORE_MAX = 11;

    private List<Card> cards = new ArrayList<>();

    public Cards() {
        IntStream.range(0, INITIAL_CARD_COUNT)
            .forEach(i -> cards.add(Deck.draw()));
    }

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public boolean isBurst() {
        if (sumWithACard() > BURST_LEVEL) {
            return true;
        }
        return false;
    }

    public int sumWithACard() {
        int score = sum();
        int ACardCount = countACard();

        while (score > BURST_LEVEL && ACardCount > 0) {
            ACardCount--;
            score -= (A_CARD_SCORE_MAX - A_CARD_SCORE_MIN);
        }
        return score;
    }

    public boolean isBlackjack() {
        if (sumWithACard() == BURST_LEVEL && cards.size() == INITIAL_CARD_COUNT) {
            return true;
        }
        return false;
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

    private int countACard() {
        return (int) cards.stream()
            .filter(card -> card.isLetter(A_CARD))
            .count();
    }

    private int sum() {
        return cards.stream()
            .map(Card::getScore)
            .reduce((score1, score2) -> score1 + score2)
            .get();
    }
}
