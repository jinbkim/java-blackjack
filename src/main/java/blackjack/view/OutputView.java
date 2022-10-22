package blackjack.view;

import blackjack.model.Dealer;
import blackjack.model.player.Player;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String REQUEST_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String WRONG_PLAYER_NAME = "잘못된 이름 입력값 입니다.";
    private static final String REQUEST_BET_AMOUNT = "의 배팅 금액은?";
    private static final String WRONG_BET_AMOUNT = "잘못된 배팅 금액 입니다.";
    private static final String[] INITIAL_CARD_DISTRIBUTION = {"딜러와 ", "에게 2장의 카드를 나누었습니다."};
    private static final String REQUEST_DRAW_CARD = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String WRONG_IS_DRAW_CARD = "y 또는 n만 입력하세요.";
    private static final String DEALER_DRAW_CARD = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    private static final String DEALER = "딜러";
    private static final String CARD_STATE = "카드: ";
    private static final String PLAYER_NAME_JOIN_DEL = ", ";
    private static final String NEWLINE = "\n";
    private static final String RESULT = " - 결과: ";
    private static final String MONEY_RESULT = "## 최종 수익";
    private static final String COLON = ": ";

    public static void printWrongPlayerName() {
        System.out.println(WRONG_PLAYER_NAME);
    }

    public static void printWrongBetAmount() {
        System.out.println(WRONG_BET_AMOUNT);
    }

    public static void printRequestPlayerName() {
        System.out.println(REQUEST_PLAYER_NAME);
    }

    public static void printRequestPlayerBetAmount(String playerName) {
        System.out.println(NEWLINE + playerName + REQUEST_BET_AMOUNT);
    }

    public static void printInitialCardDistribution(List<Player> players, Dealer dealer) {
        String playerNames = players.stream()
            .map(player -> player.getName())
            .collect(Collectors.joining(PLAYER_NAME_JOIN_DEL));

        System.out.println(NEWLINE + INITIAL_CARD_DISTRIBUTION[0] + playerNames + INITIAL_CARD_DISTRIBUTION[1]);
        printDealerCards(dealer);
        printPlayersCards(players);
    }

    public static void printPlayerCards(Player player) {
        System.out.println(player.getName() + CARD_STATE + player.getCards());
    }

    public static void printRequestDrawCard(String playerName) {
        System.out.println(playerName + REQUEST_DRAW_CARD);
    }

    public static void printWrongIsDrawCard() {
        System.out.println(WRONG_IS_DRAW_CARD);
    }

    public static void printDealerDrawCard() {
        System.out.println(DEALER_DRAW_CARD);
    }

    public static void printResult(List<Player> players, Dealer dealer) {
        System.out.println();
        printDealerCardResult(dealer);
        printPlayersCardResult(players);
        System.out.println();
        System.out.println(MONEY_RESULT);
        printDealerMoneyResult(dealer);
        printPlayersMoneyResult(players);
    }

    private static void printDealerMoneyResult(Dealer dealer) {
        System.out.println(DEALER + COLON + dealer.getMoney());
    }

    private static void printPlayersMoneyResult(List<Player> players) {
        players.forEach(player -> printPlayerMoneyResult(player));
    }

    private static void printPlayerMoneyResult(Player player) {
        System.out.println(player.getName() + COLON + player.getMoney());
    }


    private static void printDealerCards(Dealer dealer) {
        System.out.println(DEALER + CARD_STATE + dealer.getCards()
            .toString());
    }

    private static void printPlayersCards(List<Player> players) {
        players.forEach(player -> printPlayerCards(player));
    }

    private static void printDealerCardResult(Dealer dealer) {
        System.out.println(DEALER + CARD_STATE + dealer.getCards()
            .toString() + RESULT + dealer.getCards()
            .getCardNumSumWithACard());
    }

    private static void printPlayersCardResult(List<Player> players) {
        players.forEach(player -> {
            printPlayerCardResult(player);
        });
    }

    private static void printPlayerCardResult(Player player) {
        System.out.println(player.getName() + CARD_STATE + player.getCards() + RESULT + player.getCards()
            .getCardNumSumWithACard());
    }
}
