package model.card;

public class Dealer {

    private Cards cards = new Cards();

    public Cards getCards() {
        return cards;
    }

    public Card getCardOne() {
        return cards.get()
            .get(0);
    }
}
