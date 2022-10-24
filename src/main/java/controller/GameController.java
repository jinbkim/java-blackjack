package controller;

import model.PlayersBetMoney;
import model.PlayersName;
import view.InputView;

public class GameController {

    public static void run() {
        PlayersName playersName = InputView.requestPlayerName();
        PlayersBetMoney playersBetMoney = InputView.requestPlayersBetMoney(playersName.get());
    }
}
