package blackjack.model.player;

import blackjack.model.Dealer;
import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    public Players(List<String> names, List<Integer> betAmounts) {
        players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), betAmounts.get(i)));
        }
    }

    public void calculateMoney(Dealer dealer) {
        players.forEach(player -> player.calculateMoney(dealer));
    }

    public List<Player> get() {
        return players;
    }
}
