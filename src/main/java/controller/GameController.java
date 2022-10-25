package controller;

import model.player.Dealer;
import model.player.Players;
import model.player.PlayersBetMoney;
import model.player.PlayersName;
import view.InputView;
import view.OutputView;

public class GameController {

    public static void run() {
        PlayersName playersName = InputView.requestPlayerName();
        PlayersBetMoney playersBetMoney = InputView.requestPlayersBetMoney(playersName.get());
        Players players = new Players(playersName.get(), playersBetMoney.get());
        Dealer dealer = new Dealer();

        OutputView.printInitialCardDraw(players.get(), dealer);
        InputView.requestPlayersDrawCard(players.get());
        dealer.drawMore();
        players.get()
            .forEach(player -> player.battle(dealer));
        OutputView.printGameResult(players.get(), dealer);
    }
}
