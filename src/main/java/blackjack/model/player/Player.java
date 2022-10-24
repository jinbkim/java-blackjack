package blackjack.model.player;

import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;

public class Player extends User {

    private static final int INITIAL_CARD_COUNT = 2;
    private static final double BLACKJACK_DIVIDEND_RATE = 1.5;

    private final String name;
    private final int betAmount;

    public Player(String name, int betAmount) {
        this.name = name;
        this.betAmount = betAmount;
        cards = new Cards(INITIAL_CARD_COUNT);
    }

    public Player(String name, int betAmount, Cards cards, GameStatus gameStatus) {
        this.name = name;
        this.betAmount = betAmount;
        this.cards = cards;
        this.gameStatus = gameStatus;
    }

    public boolean isBlackjack() {
        if (cards.isBlackjack()) {
            gameStatus = GameStatus.BLACKJACK;
            return true;
        }
        return false;
    }

    public void calculateMoney(User dealer) {
        if (isPlayerOnlyBlackjack(dealer)) {
            playerWin((int) (BLACKJACK_DIVIDEND_RATE * betAmount), dealer);
        }
        else if (isPlayerWin(dealer)) {
            playerWin(betAmount, dealer);
        }
        else if (isPlayerLose(dealer)) {
            playerLose(betAmount, dealer);
        }
    }

    @Override
    public void drawCard() {
        cards.add(CardCollection.draw());
        if (cards.isBurst()) {
            gameStatus = GameStatus.BURST;
        }
        if (cards.is21()) {
            gameStatus = GameStatus.DONE;
        }
    }

    public String getName() {
        return name;
    }

    private void playerWin(int betAmount, User dealer) {
        winMoney(betAmount);
        dealer.loseMoney(betAmount);
    }

    private void playerLose(int betAmount, User dealer) {
        loseMoney(betAmount);
        dealer.winMoney(betAmount);
    }

    private boolean isPlayerOnlyBlackjack(User dealer) {
        if (gameStatus == GameStatus.BLACKJACK && dealer.gameStatus != GameStatus.BLACKJACK) {
            return true;
        }
        return false;
    }

    private boolean isPlayerWin(User dealer) {
        if (gameStatus == GameStatus.DONE && dealer.gameStatus == GameStatus.BURST) {
            return true;
        }
        else if (gameStatus == GameStatus.DONE && dealer.gameStatus != GameStatus.BURST && cards.isSumBigger(dealer.getCards())) {
            return true;
        }
        return false;
    }

    private boolean isPlayerLose(User dealer) {
        if (gameStatus == GameStatus.BURST) {
            return true;
        }
        else if (gameStatus == GameStatus.DONE && dealer.gameStatus != GameStatus.BURST && cards.isSumSmaller(dealer.getCards())) {
            return true;
        }
        return false;
    }
}
