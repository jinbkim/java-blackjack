package model.player;

import model.card.Cards;

public class Player extends User {

    private static final double BLACKJACK_BONUS = 1.5;

    private final String name;
    private final int betMoney;

    public Player(String name, int betMoney) {
        this.name = name;
        this.betMoney = betMoney;
    }

    public Player(Cards cards) {
        name = "";
        betMoney = 10;
        this.cards = cards;
    }

    public void battle(Dealer dealer) {
        if (isPlayerOnlyBlackjack(dealer)) {
            winPlayer(dealer, (int) (BLACKJACK_BONUS * betMoney));
        }
        else if (isPlayerWin(dealer)) {
            winPlayer(dealer, betMoney);
        }
        else if (isPlayerLose(dealer)) {
            losePlayer(dealer, betMoney);
        }
    }

    public String getName() {
        return name;
    }

    private boolean isPlayerOnlyBlackjack(Dealer dealer) {
        if (cards.isBlackjack() && !dealer.cards.isBlackjack()) {
            return true;
        }
        return false;
    }

    private boolean isPlayerWin(Dealer dealer) {
        if (!cards.isBurst() && dealer.isBurst()) {
            return true;
        }
        if (!cards.isBurst() && !dealer.isBurst() && cardSum() > dealer.cardSum()) {
            return true;
        }
        return false;
    }

    private boolean isPlayerLose(Dealer dealer) {
        if (isBurst()) {
            return true;
        }
        if (!cards.isBurst() && !dealer.isBurst() && cardSum() < dealer.cardSum()) {
            return true;
        }
        return false;
    }

    private void winPlayer(Dealer dealer, int money) {
        winMoney(money);
        dealer.loseMoney(money);
    }

    private void losePlayer(Dealer dealer, int money) {
        loseMoney(money);
        dealer.winMoney(money);
    }
}
