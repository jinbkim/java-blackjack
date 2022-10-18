package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerBetAmounts {

    private final List<Integer> betAmounts = new ArrayList<>();

    public void add(int betAmount) {
        betAmounts.add(betAmount);
    }

    public List<Integer> getBetAmounts() {
        return betAmounts;
    }
}
