package blackjack.model;

import blackjack.model.card.Card;
import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;
import blackjack.view.OutputView;

public class Dealer {

    private static final int INITIAL_CARD_COUNT = 1;
    private static final int DRAW_POSSIBLE_LEVEL = 16;

    private final Cards cards = new Cards(INITIAL_CARD_COUNT);
    private int money = 0;
    private GameStatus gameStatus = GameStatus.IN_GAME;

    public Cards getCards() {
        return cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void drawCard() {
        if (cards.is21()) {
            gameStatus = GameStatus.BLACKJACK;
            return;
        }
        while (cards.getCardNumSumWithACard() <= DRAW_POSSIBLE_LEVEL) {
            add(CardCollection.draw());
            OutputView.printDealerDrawCard();
        }
        gameStatus = GameStatus.DONE;
        if (cards.isBurst()) {
            gameStatus = GameStatus.BURST;
        }
    }

    public void win(int money) {
        this.money += money;
    }

    public void lose(int money) {
        this.money -= money;
    }

    public boolean isGameStatus(GameStatus gameStatus) {
        return this.gameStatus == gameStatus;
    }

}
