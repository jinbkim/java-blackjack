package blackjack.model;

import blackjack.model.card.Card;
import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;
import blackjack.view.OutputView;

public class Dealer {

    private static final int INITIAL_CARD_COUNT = 1;
    private static final int DRAW_POSSIBLE_LEVEL = 16;

    private Cards cards = new Cards(INITIAL_CARD_COUNT);
    private int money = 0;
    private GameStatus gameStatus = GameStatus.IN_GAME;

    public Dealer() {

    }

    public Dealer(Cards cards, GameStatus gameStatus) {
        this.cards = cards;
        this.gameStatus = gameStatus;
    }

    public Cards getCards() {
        return cards;
    }

    public void drawCard() {
        add(CardCollection.draw());
        if (cards.isBlackjack()) {
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

    public void win(int betAmount) {
        money += betAmount;
    }

    public void lose(int betAmount) {
        money -= betAmount;
    }

    public boolean isGameStatus(GameStatus gameStatus) {
        return this.gameStatus == gameStatus;
    }

    public boolean isMoney(int money) {
        return this.money == money;
    }

    public int getMoney() {
        return money;
    }

    private void add(Card card) {
        cards.add(card);
    }
}
