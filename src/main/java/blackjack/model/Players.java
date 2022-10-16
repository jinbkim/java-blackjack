package blackjack.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String SPACE_REGEX = "\\s";
    private static final String PLAYER_SEP_REGEX = ",";

    private List<Player> players;

    public Players(String input) {
        input = input.replaceAll(SPACE_REGEX, "");
        players = Arrays.stream(input.split(PLAYER_SEP_REGEX))
            .map((p) -> new Player(p))
            .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return players;
    }
}
