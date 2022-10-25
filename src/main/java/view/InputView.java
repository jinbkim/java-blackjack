package view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.player.PlayersBetMoney;
import model.player.PlayersName;
import utils.Utils;

public class InputView {

    private static final String REQUEST_DRAW_CARD_REGEX = "^[yn]{1}$";
    private static final Scanner scanner = new Scanner(System.in);

    public static PlayersName printRequestPlayerName() {
        OutputView.printRequestPlayerName();
        try {
            return new PlayersName(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongPlayerName();
            return printRequestPlayerName();
        }
    }

    public static PlayersBetMoney requestPlayersBetMoney(List<String> names) {
        PlayersBetMoney playersBetMoney = new PlayersBetMoney();
        names.forEach(name -> printRequestPlayerBetMoney(playersBetMoney, name));

        return playersBetMoney;
    }

    public static void printRequestDrawCard(String name) {
        OutputView.printRequestDrawCard(name);
        String input = scanner.nextLine();
        try {
            validateRequestDrawCard(Utils.deleteAllSpace(input));
        } catch (IllegalArgumentException e) {
            OutputView.printWrongRequestDrawCard();
            printRequestDrawCard(name);
        }
    }

    private static void printRequestPlayerBetMoney(PlayersBetMoney playersBetMoney, String name) {
        OutputView.printRequestPlayerBetMoney(name);
        try {
            playersBetMoney.add(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongPlayerBetMoney();
            printRequestPlayerBetMoney(playersBetMoney, name);
        }
    }

    static void validateRequestDrawCard(String input) {
        if (!Pattern.matches(REQUEST_DRAW_CARD_REGEX, input)) {
            throw new IllegalArgumentException();
        }
    }

}
