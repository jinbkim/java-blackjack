package blackjack.controller;

import blackjack.model.player.Dealer;
import blackjack.model.player.PlayerBetAmounts;
import blackjack.model.player.PlayerNames;
import blackjack.model.player.Players;
import blackjack.view.InputView;

public class GameController {

    public void run() {
        PlayerNames playerNames = InputView.requestPlayerName();
        PlayerBetAmounts playerBetAmounts = InputView.requestPlayerBetAmounts(playerNames);
        Players players = new Players(playerNames.getNames(), playerBetAmounts.getBetAmounts());
        Dealer dealer = new Dealer();

    }
}
