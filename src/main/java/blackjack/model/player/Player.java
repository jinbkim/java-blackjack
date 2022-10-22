package blackjack.model.player;

import blackjack.model.GameStatus;
import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;

public class Player {

    private static final int INITIAL_CARD_COUNT = 2;

    private final String name;
    private int money;
    private Cards cards = new Cards(INITIAL_CARD_COUNT);
    private GameStatus gameStatus = GameStatus.IN_GAME;

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

    public void drawCard() {
        cards.add(CardCollection.draw());
        if (cards.isBurst()) {
            gameStatus = GameStatus.BURST;
        }
        if (cards.is21()) {
            gameStatus = GameStatus.DONE;
        }
        return gameStatus;
    }

    public boolean isBlackjack() {
        if (cards.get()
            .size() == INITIAL_CARD_COUNT && cards.is21()) {
            gameStatus = GameStatus.BLACKJACK;
            return true;
        }
        return false;
    }

    public void gameDone() {
        gameStatus = GameStatus.DONE;
    }

//    public void calculateMoney(Dealer dealer) {
//        if (gameStatus == GameStatus.BURST) {
//            lose(money);
//            dealer.win(money);
//        }
//        if (gameStatus == GameStatus.BLACKJACK && !dealer.isBlackjack()) {
//            win((int) BLACKJACK_DIVIDEND_RATE * money);
//            dealer.lose((int) BLACKJACK_DIVIDEND_RATE * money);
//        }
//        if (gameStatus == GameStatus.DONE)
//    }
//
//    public void win(int money) {
//        this.money += money;
//    }
//
//    public void lose(int money) {
//        this.money -= money;
//    }

    public boolean isGameStatus(GameStatus gameStatus) {
        return this.gameStatus == gameStatus;
    }
}
