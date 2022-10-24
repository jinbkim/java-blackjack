package controller;

import model.card.Players;
import model.player.PlayersBetMoney;
import model.player.PlayersName;
import view.InputView;

public class GameController {

    public static void run() {
        PlayersName playersName = InputView.requestPlayerName();
        PlayersBetMoney playersBetMoney = InputView.requestPlayersBetMoney(playersName.get());
        Players players = new Players(playersName.get(), playersBetMoney.get());
    }
}
