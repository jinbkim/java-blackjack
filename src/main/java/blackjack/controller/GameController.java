package blackjack.controller;

import blackjack.view.InputView;

public class GameController {

    final InputView inputView = new InputView();

    public void run() {
        inputView.requestPlayer();
    }
}
