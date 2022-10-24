package blackjack.model.player;

import blackjack.model.card.Card;
import blackjack.model.card.Cards;

public abstract class User {

    protected Cards cards;
    protected GameStatus gameStatus = GameStatus.IN_GAME;
    private int money = 0;

    public void gameDone() {
        gameStatus = GameStatus.DONE;
    }

    public boolean isMoney(int money) {
        return this.money == money;
    }

    public boolean isGameStatus(GameStatus gameStatus) {
        return this.gameStatus == gameStatus;
    }

    public void winMoney(int betAmount) {
        money += betAmount;
    }

    public void loseMoney(int betAmount) {
        money -= betAmount;
    }

    public int getMoney() {
        return money;
    }

    public Cards getCards() {
        return cards;
    }

    protected void add(Card card) {
        cards.add(card);
    }

    public abstract void drawCard();
}
