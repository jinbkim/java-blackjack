package blackjack.model.player;

import blackjack.model.Dealer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private List<Player> players = new ArrayList<>();

    public Players(List<String> names, List<Integer> betAmounts) {
        IntStream.range(0, names.size())
            .forEach(i -> players.add(new Player(names.get(i), betAmounts.get(i))));
    }

    public void calculateMoney(Dealer dealer) {
        players.forEach(player -> player.calculateMoney(dealer));
    }

    public List<Player> get() {
        return players;
    }
}
