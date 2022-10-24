package view;

import java.util.List;
import java.util.Scanner;
import model.player.PlayersBetMoney;
import model.player.PlayersName;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static PlayersName requestPlayerName() {
        OutputView.requestPlayerName();
        try {
            return new PlayersName(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.wrongPlayerName();
            return requestPlayerName();
        }
    }

    public static PlayersBetMoney requestPlayersBetMoney(List<String> names) {
        PlayersBetMoney playersBetMoney = new PlayersBetMoney();
        names.forEach(name -> requestPlayerBetMoney(playersBetMoney, name));

        return playersBetMoney;
    }

    private static void requestPlayerBetMoney(PlayersBetMoney playersBetMoney, String name) {
        OutputView.requestPlayerBetMoney(name);
        try {
            playersBetMoney.add(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.wrongPlayerBetMoney();
            requestPlayerBetMoney(playersBetMoney, name);
        }
    }
}
