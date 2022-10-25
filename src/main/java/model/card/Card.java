package model.card;

public class Card {

    private final CardLetter cardLetter;
    private final CardShape cardShape;

    public Card(CardLetter cardLetter, CardShape cardShape) {
        this.cardLetter = cardLetter;
        this.cardShape = cardShape;
    }

    public Card(String value) {
        cardLetter = CardLetter.valueOf(value);
        cardShape = CardShape.CLOVER;
    }

    @Override
    public String toString() {
        return cardLetter.getLetter() + cardShape.getShape();
    }

    public int getScore() {
        return cardLetter.getScore();
    }

    public boolean isLetter(String letter) {
        return letter == cardLetter.getLetter();
    }
}
