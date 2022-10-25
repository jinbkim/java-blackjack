package model.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> playersName, List<Integer> playersBetMoney) {
        IntStream.range(0, playersName.size())
            .forEach(i -> players.add(new Player(playersName.get(i), playersBetMoney.get(i))));
    }

    public void battle(Dealer dealer) {
        players.forEach(player -> player.battle(dealer));
    }

    public List<Player> get() {
        return players;
    }
}
