package blackjack.model.card;

import java.util.Collections;
import java.util.Stack;

public class CardCollection {

    private static Stack<Card> cards = new Stack<>();

    static {
        insertAllCards();
    }

    public static Card draw() {
        return cards.pop();
    }

    public static Stack<Card> getCards() {
        return cards;
    }

    private static void insertAllCards() {
        CardShape[] cardShapes = CardShape.values();
        CardLetter[] cardLetters = CardLetter.values();

        for (CardShape cardShape : cardShapes) {
            for (CardLetter cardLetter : cardLetters) {
                cards.add(new Card(cardLetter, cardShape));
            }
        }
        Collections.shuffle(cards);
    }
}
