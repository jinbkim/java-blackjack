package blackjack.model.card;

public class Card {

    private CardLetter letter;
    private CardShape shape;

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

}
