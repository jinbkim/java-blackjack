package view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.player.Player;
import model.player.PlayersBetMoney;
import model.player.PlayersName;
import utils.Utils;

public class InputView {

    private static final String REQUEST_DRAW_CARD_REGEX = "^[yn]{1}$";
    private static final String IS_DRAW_CARD = "y";
    private static final Scanner scanner = new Scanner(System.in);

    public static PlayersName requestPlayerName() {
        OutputView.printRequestPlayerName();
        try {
            return new PlayersName(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongPlayerName();
            return requestPlayerName();
        }
    }

    public static PlayersBetMoney requestPlayersBetMoney(List<String> names) {
        PlayersBetMoney playersBetMoney = new PlayersBetMoney();
        names.forEach(name -> requestPlayerBetMoney(playersBetMoney, name));

        return playersBetMoney;
    }

    public static void requestPlayersDrawCard(List<Player> players) {
        players.forEach(player -> {
            if (!player.isSum21()) {
                requestPlayerDrawCard(player);
            }
        });
    }

    private static void requestPlayerBetMoney(PlayersBetMoney playersBetMoney, String name) {
        OutputView.printRequestPlayerBetMoney(name);
        try {
            playersBetMoney.add(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongPlayerBetMoney();
            requestPlayerBetMoney(playersBetMoney, name);
        }
    }

    static void validateRequestDrawCard(String input) {
        if (!Pattern.matches(REQUEST_DRAW_CARD_REGEX, input)) {
            throw new IllegalArgumentException();
        }
    }

    private static void requestPlayerDrawCard(Player player) {
        OutputView.printRequestDrawCard(player.getName());
        String input = Utils.deleteAllSpace(scanner.nextLine());

        try {
            validateRequestDrawCard(input);
        } catch (IllegalArgumentException e) {
            OutputView.printWrongRequestDrawCard();
            requestPlayerDrawCard(player);
            return;
        }
        drawCard(input, player);
    }

    private static void drawCard(String input, Player player) {
        if (!input.equals(IS_DRAW_CARD)) {
            return;
        }
        player.draw();
        OutputView.printPlayerCard(player);
        if (!player.isBurst() && !player.isSum21()) {
            requestPlayerDrawCard(player);
        }
    }

}
