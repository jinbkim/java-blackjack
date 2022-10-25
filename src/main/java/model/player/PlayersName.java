package model.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.Utils;

public class PlayersName {

    private static final String PLAYER_NAME_DELIMITER = ",";

    private final List<String> names;

    public PlayersName(String input) {
        names = Arrays.stream(Utils.deleteAllSpace(input)
                .split(PLAYER_NAME_DELIMITER))
            .collect(Collectors.toList());
        names.forEach(this::validatePlayerName);
    }

    public List<String> get() {
        return names;
    }

    private void validatePlayerName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
