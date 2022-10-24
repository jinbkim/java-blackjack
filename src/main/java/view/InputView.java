package view;

import java.util.Scanner;
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
}
