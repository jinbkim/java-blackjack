package blackjack.controller;

import blackjack.model.PlayerBetAmounts;
import blackjack.model.PlayerNames;
import blackjack.model.Players;
import blackjack.view.InputView;

public class GameController {

    final InputView inputView = new InputView();

    public void run() {
        PlayerNames playerNames = inputView.requestPlayerName();
        PlayerBetAmounts playerBetAmounts = inputView.requestPlayerBetAmounts(playerNames);
        Players players = new Players(playerNames.getNames(), playerBetAmounts.getBetAmounts());
    }
}
