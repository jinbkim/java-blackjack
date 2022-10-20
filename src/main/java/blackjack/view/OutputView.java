package blackjack.view;

public class OutputView {

    private static final String REQUEST_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String WRONG_PLAYER_NAME = "잘못된 이름 입력값 입니다.";
    private static final String REQUEST_BET_AMOUNT = "의 배팅 금액은?";
    private static final String WRONG_BET_AMOUNT = "잘못된 배팅 금액 입니다.";

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
        System.out.println(playerName + REQUEST_BET_AMOUNT);
    }
}
