package domain;

public enum UIMessage {
    HOW_MONEY("구입금액을 입력해 주세요."),
    BUY_RESULT("%d개를 구매했습니다.\n"),
    LAST_WINNING_NUM("\n지난 주 당첨 번호를 입력해주세요."),
    BONUS_NUM("보너스 볼을 입력해 주세요."),
    WINNING_RESULT("당첨 통계\n---------\n3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n5개 일치 (1500000원)- %d개\n6개 일치 (2000000000원)- %d개\n총 수익률은 %d%%입니다.");

    private final String message;

    UIMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
