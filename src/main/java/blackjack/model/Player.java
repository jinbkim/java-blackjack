package blackjack.model;

import blackjack.view.OutputView;

public class Player {

    private String name;

    public Player(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(OutputView.WRONG_PLAYER_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
