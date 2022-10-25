package model.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private static Stack<Card> cards = new Stack<>();

    static {
        createDeck();
    }

    public static void createDeck() {
        Arrays.stream(CardLetter.values())
            .forEach(cardLetter -> Arrays.stream(CardShape.values())
                .forEach(cardShape -> cards.add(new Card(cardLetter, cardShape))));
        Collections.shuffle(cards);
    }


    public static Card draw() {
        return cards.pop();
    }
}
