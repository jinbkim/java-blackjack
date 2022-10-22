package blackjack.model.player;

import blackjack.model.Dealer;
import blackjack.model.GameStatus;
import blackjack.model.card.CardCollection;
import blackjack.model.card.Cards;

public class Player {

    private static final int INITIAL_CARD_COUNT = 2;
    private static final double BLACKJACK_DIVIDEND_RATE = 1.5;

    private final String name;
    private int money = 0;
    private int betAmount;
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
        if (gameStatus == GameStatus.BURST) {
            lose(betAmount);
            dealer.win(betAmount);
        }
        else if (gameStatus == GameStatus.BLACKJACK && !dealer.isGameStatus(GameStatus.BLACKJACK)) {
            win((int) (BLACKJACK_DIVIDEND_RATE * betAmount));
            dealer.lose((int) (BLACKJACK_DIVIDEND_RATE * betAmount));
        }
        else if (gameStatus == GameStatus.DONE && dealer.isGameStatus(GameStatus.BURST)) {
            win(betAmount);
            dealer.lose(betAmount);
        }
        else if (gameStatus == GameStatus.DONE && !dealer.isGameStatus(GameStatus.BURST)) {
            if (cards.diff(dealer.getCards()) > 0) {
                win(betAmount);
                dealer.lose(betAmount);
            }
            else if (cards.diff(dealer.getCards()) < 0) {
                lose(betAmount);
                dealer.win(betAmount);
            }
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

    public String getName() {
        return name;
    }

    public Cards getCards() {
        return cards;
    }

    public int getMoney() {
        return money;
    }
}
