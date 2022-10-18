package blackjack.model;

import blackjack.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class PlayerNames {

    private static final String SPACE_REGEX = "\\s";
    private static final String PLAYER_SEP_REGEX = ",";

    private final List<String> names;

    public PlayerNames(String input) {
        String noSpaceInput = input.replaceAll(SPACE_REGEX, "");
        names = Arrays.asList(noSpaceInput.split(PLAYER_SEP_REGEX));

        if (hasPlayerEmptyName(names)) {
            throw new IllegalArgumentException(OutputView.WRONG_PLAYER_NAME);
        }
    }

    public List<String> getNames() {
        return names;
    }

    private boolean hasPlayerEmptyName(List<String> playersName) {
        return playersName.stream()
            .filter(name -> name.length() == 0)
            .count() != 0;
    }
}
