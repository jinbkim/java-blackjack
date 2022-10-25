package view;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import model.card.Player;
import model.card.Players;
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

    public static void playersRequestDrawCard(Players players) {
        players.get()
            .forEach(InputView::playerRequestDrawCard);
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

    private static void playerRequestDrawCard(Player player) {
        OutputView.printRequestDrawCard(player.getName());
        String input = scanner.nextLine();

        try {
            validateRequestDrawCard(Utils.deleteAllSpace(input));
        } catch (IllegalArgumentException e) {
            OutputView.printWrongRequestDrawCard();
            playerRequestDrawCard(player);
        }
        if (Utils.deleteAllSpace(input)
            .equals(IS_DRAW_CARD)) {
            player.draw();
            OutputView.printPlayerCard(player);
            playerRequestDrawCard(player);
        }
    }

}
