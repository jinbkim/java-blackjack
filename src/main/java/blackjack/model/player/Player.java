package blackjack.model.player;

import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;

public class Player {

    private static final int INITIAL_CARD_COUNT = 2;
    private static final double BLACKJACK_DIVIDEND_RATE = 1.5;

    private final String name;
    private final int betAmount;

    private int money = 0;
    private Cards cards = new Cards(INITIAL_CARD_COUNT);
    private GameStatus gameStatus = GameStatus.IN_GAME;

    public Player(String name, int betAmount) {
        this.name = name;
        this.betAmount = betAmount;
    }

    public Player(String name, int betAmount, Cards cards, GameStatus gameStatus) {
        this.name = name;
        this.betAmount = betAmount;
        this.cards = cards;
        this.gameStatus = gameStatus;
    }

    public void drawCard() {
        cards.add(CardCollection.draw());
        if (cards.isBurst()) {
            gameStatus = GameStatus.BURST;
        }
        if (cards.is21()) {
            gameStatus = GameStatus.DONE;
        }
    }

    public boolean isBlackjack() {
        if (cards.isBlackjack()) {
            gameStatus = GameStatus.BLACKJACK;
            return true;
        }
        return false;
    }

    public void gameDone() {
        gameStatus = GameStatus.DONE;
    }

    public void calculateMoney(Dealer dealer) {
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

    public void winMoney(int betAmount) {
        money += betAmount;
    }

    public void loseMoney(int betAmount) {
        money -= betAmount;
    }

    public boolean isGameStatus(GameStatus gameStatus) {
        return this.gameStatus == gameStatus;
    }

    public boolean isMoney(int money) {
        return this.money == money;
    }

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }

    public int getMoney() {
        return money;
    }

    private void playerWin(int betAmount, Dealer dealer) {
        winMoney(betAmount);
        dealer.lose(betAmount);
    }

    private void playerLose(int betAmount, Dealer dealer) {
        loseMoney(betAmount);
        dealer.win(betAmount);
    }

    private boolean isPlayerOnlyBlackjack(Dealer dealer) {
        if (gameStatus == GameStatus.BLACKJACK && !dealer.isGameStatus(GameStatus.BLACKJACK)) {
            return true;
        }
        return false;
    }

    private boolean isPlayerWin(Dealer dealer) {
        if (gameStatus == GameStatus.DONE && dealer.isGameStatus(GameStatus.BURST)) {
            return true;
        }
        else if (gameStatus == GameStatus.DONE && !dealer.isGameStatus(GameStatus.BURST) && cards.isSumBigger(dealer.getCards())) {
            return true;
        }
        return false;
    }

    private boolean isPlayerLose(Dealer dealer) {
        if (gameStatus == GameStatus.BURST) {
            return true;
        }
        else if (gameStatus == GameStatus.DONE && !dealer.isGameStatus(GameStatus.BURST) && cards.isSumSmaller(dealer.getCards())) {
            return true;
        }
        return false;
    }
}
