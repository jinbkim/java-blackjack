package model.card;

public class Card {

    private final CardLetter cardLetter;
    private final CardShape cardShape;

    public Card(CardLetter cardLetter, CardShape cardShape) {
        this.cardLetter = cardLetter;
        this.cardShape = cardShape;
    }
}
