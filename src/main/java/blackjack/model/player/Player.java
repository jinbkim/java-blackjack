package blackjack.model.player;

import blackjack.model.GameStatus;
import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;

public class Player {

    private static final int INITIAL_CARD_COUNT = 2;

    private final String name;
    private int money;
    private Cards cards = new Cards(INITIAL_CARD_COUNT);

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Cards getCards() {
        return cards;
    }

    public GameStatus drawCard() {
        cards.add(CardCollection.draw());
        if (cards.isBurst()) {
            return GameStatus.BURST;
        }
        if (cards.is21()) {
            return GameStatus.BLACKJACK;
        }
        return GameStatus.IN_GAME;
    }
}
