package blackjack.model.player;

import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;
import blackjack.view.OutputView;

public class Dealer extends User {

    private static final int INITIAL_CARD_COUNT = 1;
    private static final int DRAW_POSSIBLE_LEVEL = 16;

    public Dealer() {
        cards = new Cards(INITIAL_CARD_COUNT);
    }

    public Dealer(Cards cards, GameStatus gameStatus) {
        this.cards = cards;
        this.gameStatus = gameStatus;
    }

    @Override
    public void drawCard() {
        add(CardCollection.draw());
        while (cards.calculateSumWithACard() <= DRAW_POSSIBLE_LEVEL) {
            add(CardCollection.draw());
            OutputView.printDealerDrawCard();
        }
        gameStatus = calculateGameStatus();
    }

    private GameStatus calculateGameStatus() {
        if (cards.isBlackjack()) {
            return GameStatus.BLACKJACK;
        }
        if (cards.isBurst()) {
            return GameStatus.BURST;
        }
        return GameStatus.DONE;
    }

}
