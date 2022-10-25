package model.card;

public class Dealer extends User {

    public Card getCardOne() {
        return cards.get()
            .get(0);
    }
}
