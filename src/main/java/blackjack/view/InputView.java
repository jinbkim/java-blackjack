package blackjack.view;

import blackjack.model.PlayerBetAmounts;
import blackjack.model.PlayerNames;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static String ONLY_NUMBER_REGEX = "^[0-9]*$";

    public PlayerNames requestPlayerName() {
        String input = requestInput(OutputView.REQUEST_PLAYER_NAME);

        try {
            return new PlayerNames(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPlayerName();
        }
    }

    public PlayerBetAmounts requestPlayerBetAmounts(PlayerNames playerNames) {
        PlayerBetAmounts playerBetAmounts = new PlayerBetAmounts();

        for (String name : playerNames.getNames()) {
            playerBetAmounts.add(requestPlayerBetAmount(name));
        }
        return playerBetAmounts;
    }

    public void validateBetAmount(String input) {
        if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(OutputView.WRONG_BET_AMOUNT);
        }
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(OutputView.WRONG_BET_AMOUNT);
        }
    }

    private int requestPlayerBetAmount(String playerName) {
        String input = requestInput(playerName + OutputView.REQUEST_BET_AMOUNT);

        try {
            validateBetAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPlayerBetAmount(playerName);
        }
        return Integer.parseInt(input);
    }

    private String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
