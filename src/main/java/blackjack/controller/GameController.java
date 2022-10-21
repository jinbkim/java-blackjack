package blackjack.controller;

import blackjack.model.Dealer;
import blackjack.model.card.CardCollection;
import blackjack.model.player.PlayerBetAmounts;
import blackjack.model.player.PlayerNames;
import blackjack.model.player.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameController {

    public void run() {
        PlayerNames playerNames = InputView.requestPlayerName();
        PlayerBetAmounts playerBetAmounts = InputView.requestPlayerBetAmounts(playerNames);
        Players players = new Players(playerNames.getNames(), playerBetAmounts.getBetAmounts());
        Dealer dealer = new Dealer();

        OutputView.printInitialCardDistribution(players.get(), dealer);
        dealer.add(CardCollection.draw());
        InputView.requestPlayersDrawCard(players.get());
        dealer.drawCard();
        OutputView.printCardResult(players.get(), dealer);
    }
}
