package blackjack.view;

import blackjack.model.player.PlayerBetAmounts;
import blackjack.model.player.PlayerNames;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    private static final String SPACE_REGEX = "\\s";

    public static PlayerNames requestPlayerName() {
        OutputView.printRequestPlayerName();
        String input = requestInput();

        try {
            return new PlayerNames(input);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongPlayerName();
            return requestPlayerName();
        }
    }

    public static PlayerBetAmounts requestPlayerBetAmounts(PlayerNames playerNames) {
        PlayerBetAmounts playerBetAmounts = new PlayerBetAmounts();

        for (String name : playerNames.getNames()) {
            playerBetAmounts.add(requestPlayerBetAmount(name));
        }
        return playerBetAmounts;
    }

    public static void validateBetAmount(String input) {
        if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static int requestPlayerBetAmount(String playerName) {
        OutputView.printRequestPlayerBetAmount(playerName);
        String input = requestInput();
        String noSpaceInput = input.replaceAll(SPACE_REGEX, input);

        try {
            validateBetAmount(noSpaceInput);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongBetAmount();
            return requestPlayerBetAmount(playerName);
        }
        return Integer.parseInt(noSpaceInput);
    }

    private static String requestInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
