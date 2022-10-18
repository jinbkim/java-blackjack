package blackjack.controller;

import blackjack.view.InputView;
import java.util.List;

public class GameController {

    final InputView inputView = new InputView();

    public void run() {
        List<String> playersName = inputView.requestPlayerName();
        List<Integer> playersBetAmount = inputView.requestPlayersBetAmount(playersName);
    }
}
