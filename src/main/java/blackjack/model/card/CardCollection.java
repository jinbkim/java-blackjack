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

    private static void insertAllCards() {
        CardShape[] cardShapes = CardShape.values();

        for (CardShape cardShape : cardShapes) {
            insertAllCardsDecidedShape(cardShape);
        }
        Collections.shuffle(cards);
    }

    private static void insertAllCardsDecidedShape(CardShape cardShape) {
        CardLetter[] cardLetters = CardLetter.values();

        for (CardLetter cardLetter : cardLetters) {
            cards.add(new Card(cardLetter, cardShape));
        }
    }
}
