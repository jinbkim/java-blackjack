package blackjack.model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {

    private static final String CARD_NAME_JOIN_DEL = ", ";
    private static final String A_CARD = "A";
    private static final int BLACK_JACK_LEVEL = 21;
    private static final int A_CARD_SCORE_MAX = 11;
    private static final int A_CARD_SCORE_MIN = 1;
    private static final int INITIAL_CARD_SIZE = 2;

    private List<Card> cards = new ArrayList<>();

    public Cards(int initialCardCount) {
        for (int i = 0; i < initialCardCount; i++) {
            cards.add(CardCollection.draw());
        }
    }

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int getCardNumSumWithACard() {
        int cardNumSum = getCardNumSum();
        int numOfACard = countACard();

        while (cardNumSum > BLACK_JACK_LEVEL && numOfACard > 0) {
            numOfACard--;
            cardNumSum -= (A_CARD_SCORE_MAX - A_CARD_SCORE_MIN);
        }
        return cardNumSum;
    }

    public List<Card> get() {
        return cards;
    }

    public boolean is21() {
        return getCardNumSumWithACard() == BLACK_JACK_LEVEL;
    }

    public boolean isBurst() {
        return getCardNumSumWithACard() > BLACK_JACK_LEVEL;
    }

    public int diff(Cards target) {
        return getCardNumSumWithACard() - target.getCardNumSumWithACard();
    }

    public boolean isBlackjack() {
        if (is21() && cards.size() == INITIAL_CARD_SIZE) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return cards.stream()
            .map(card -> card.toString())
            .collect(Collectors.joining(CARD_NAME_JOIN_DEL));
    }

    private int getCardNumSum() {
        return cards.stream()
            .map(card -> card.getScore())
            .reduce((x, y) -> x + y)
            .get();
    }

    private int countACard() {
        return (int) cards.stream()
            .filter(card -> card.getLetter() == A_CARD)
            .count();
    }
}
