package view;

import java.util.List;
import java.util.Scanner;
import model.player.PlayersBetMoney;
import model.player.PlayersName;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

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

    private static void printRequestPlayerBetMoney(PlayersBetMoney playersBetMoney, String name) {
        OutputView.printRequestPlayerBetMoney(name);
        try {
            playersBetMoney.add(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            OutputView.printWrongPlayerBetMoney();
            printRequestPlayerBetMoney(playersBetMoney, name);
        }
    }
}
