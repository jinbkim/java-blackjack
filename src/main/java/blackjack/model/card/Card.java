package blackjack.model.card;

public class Card {

    private final CardLetter letter;
    private final CardShape shape;

    public Card(CardLetter letter, CardShape shape) {
        this.letter = letter;
        this.shape = shape;
    }

    public String getLetter() {
        return letter.getLetter();
    }

    public String getShape() {
        return shape.getShape();
    }

    public int getScore() {
        return letter.getScore();
    }

    @Override
    public String toString() {
        return letter.getLetter() + shape.getShape();
    }
}
