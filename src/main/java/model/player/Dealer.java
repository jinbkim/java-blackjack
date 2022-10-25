package model.player;

import model.card.Card;
import view.OutputView;

public class Dealer extends User {

    private static final int DRAW_MORE_LEVEL = 16;

    public Card getCardOne() {
        return cards.get()
            .get(0);
    }

    public void drawMore() {
        while (cards.sumWithACard() < DRAW_MORE_LEVEL) {
            OutputView.printDealerDrawCard();
            draw();
        }
    }
}
