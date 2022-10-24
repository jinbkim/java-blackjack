package view;

import java.util.List;
import java.util.Scanner;
import model.PlayersBetMoney;
import model.PlayersName;

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
        names.forEach(name -> playersBetMoney.add(requestPlayerBetMoney(name)));

        return playersBetMoney;
    }

    private static String requestPlayerBetMoney(String name) {
        OutputView.requestPlayerBetMoney(name);
        return scanner.nextLine();
    }
}
