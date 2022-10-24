package blackjack.model.card;

import java.util.Arrays;
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
        Arrays.stream(CardShape.values())
            .forEach(cardShape -> Arrays.stream(CardLetter.values())
                .forEach(cardLetter -> cards.add(new Card(cardLetter, cardShape))));
    }
}
