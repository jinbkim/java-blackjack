package blackjack.view;

import blackjack.model.GameStatus;
import blackjack.model.player.Player;
import blackjack.model.player.PlayerBetAmounts;
import blackjack.model.player.PlayerNames;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";
    private static final String SPACE_REGEX = "\\s";
    private static final String IS_DRAW_CARD_REGEX = "^[yn]{1}$";
    private static final String DRAW_MORE_CARD = "y";

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

    public static void requestPlayersDrawCard(List<Player> players) {
        players.forEach(player -> {
            if (!player.isBlackjack()) {
                requestPlayerDrawCard(player);
            }
        });
    }

    private static void requestPlayerDrawCard(Player player) {
        OutputView.printRequestDrawCard(player.getName());
        String input = requestInput();
        String noSpaceInput = input.replaceAll(SPACE_REGEX, input);

        try {
            validateIsDrawCard(noSpaceInput);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongIsDrawCard();
            requestPlayerDrawCard(player);
        }
        if (!noSpaceInput.equals(DRAW_MORE_CARD)) {
            player.gameDone();
            return ;
        }
        player.drawCard();
        OutputView.printPlayerCards(player);
        if (player.isGameStatus(GameStatus.IN_GAME)) {
            requestPlayerDrawCard(player);
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

    public static void validateIsDrawCard(String input) {
        if (!Pattern.matches(IS_DRAW_CARD_REGEX, input)) {
            throw new IllegalArgumentException();
        }
    }
}
