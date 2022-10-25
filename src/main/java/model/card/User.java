package model.card;

abstract public class User {

    protected final Cards cards = new Cards();

    public Cards getCards() {
        return cards;
    }

}
