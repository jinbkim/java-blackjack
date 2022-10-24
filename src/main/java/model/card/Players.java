package model.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private List<Player> players = new ArrayList<>();

    public Players(List<String> playersName, List<Integer> playersBetMoney) {
        IntStream.range(0, playersName.size())
            .forEach(i -> players.add(new Player(playersName.get(i), playersBetMoney.get(i))));
    }
}
