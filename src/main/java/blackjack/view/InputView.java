package blackjack.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPACE_REGEX = "\\s";
    private static final String PLAYER_SEP_REGEX = ",";

    public List<String> requestPlayerName() {
        String input = requestInput(OutputView.REQUEST_PLAYER_NAME);

        try {
            return parseRequestPlayerName(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestPlayerName();
        }
    }

    public List<Integer> requestPlayersBetAmount(List<String> playersName) {
        List<Integer> playersBetAmount = new ArrayList<>();

        for (String playerName : playersName) {
            int betAmount = requestPlayerBetAmount(playerName);
            playersBetAmount.add(betAmount);
        }
        return playersBetAmount;
    }

    private int requestPlayerBetAmount(String PlayerName) {
        String input = requestInput(PlayerName + OutputView.REQUEST_BET_AMOUNT);

        return Integer.parseInt(input);
    }

    private List<String> parseRequestPlayerName(String input) {
        String noSpaceInput = input.replaceAll(SPACE_REGEX, "");
        List<String> playersName = Arrays.asList(noSpaceInput.split(PLAYER_SEP_REGEX));

        if (hasPlayerEmptyName(playersName)) {
            throw new IllegalArgumentException(OutputView.WRONG_PLAYER_NAME);
        }
        return playersName;
    }

    private boolean hasPlayerEmptyName(List<String> playersName) {
        return playersName.stream()
            .filter(name -> name.length() == 0)
            .count() != 0;
    }


    private String requestInput(String input) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(input);
        return scanner.nextLine();
    }
}
