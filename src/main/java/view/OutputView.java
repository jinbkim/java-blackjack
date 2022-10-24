package view;

public class OutputView {

    private static final String REQUEST_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String WRONG_PLAYER_NAME = "잘못된 플레이어 이름 입니다.";
    private static final String REQUEST_PLAYER_BET_MONEY = "의 배팅 금액은?";

    public static void requestPlayerName() {
        System.out.println(REQUEST_PLAYER_NAME);
    }

    public static void wrongPlayerName() {
        System.out.println(WRONG_PLAYER_NAME);
    }

    public static void requestPlayerBetMoney(String name) {
        System.out.println(name + REQUEST_PLAYER_NAME);
    }
}
