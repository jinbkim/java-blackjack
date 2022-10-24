package model.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utils.Utils;

public class PlayersName {

    private static final String PLAYER_NAME_DELIMITER = ",";

    private final List<String> names = new ArrayList<>();

    public PlayersName(String input) {
        Arrays.stream(Utils.deleteAllSpace(input)
                .split(PLAYER_NAME_DELIMITER))
            .forEach(name -> {
                validatePlayerName(name);
                names.add(name);
            });
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
