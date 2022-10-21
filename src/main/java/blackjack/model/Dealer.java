package blackjack.model;

import blackjack.model.card.Card;
import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;
import blackjack.view.OutputView;

public class Dealer {

    private static final int INITIAL_CARD_COUNT = 1;
    private static final int DRAW_POSSIBLE_LEVEL = 16;

    private final int money = 0;
    private final Cards cards = new Cards(INITIAL_CARD_COUNT);

    public Cards getCards() {
        return cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void drawCard() {
        System.out.println();
        while (cards.getCardNumSumWithACard() <= DRAW_POSSIBLE_LEVEL) {
            add(CardCollection.draw());
            OutputView.printDealerDrawCard();
        }
        System.out.println();

    }
}
