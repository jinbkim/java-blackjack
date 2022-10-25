package controller;

import model.card.Dealer;
import model.card.Players;
import model.player.PlayersBetMoney;
import model.player.PlayersName;
import view.InputView;
import view.OutputView;

public class GameController {

    public static void run() {
        PlayersName playersName = InputView.printRequestPlayerName();
        PlayersBetMoney playersBetMoney = InputView.requestPlayersBetMoney(playersName.get());
        Players players = new Players(playersName.get(), playersBetMoney.get());
        Dealer dealer = new Dealer();

        OutputView.printInitialCardDraw(players.get(), dealer);

    }
}
