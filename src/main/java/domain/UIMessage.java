package domain;

public enum UIMessage {
    HOW_MONEY("구입금액을 입력해 주세요."),
    BUY_RESULT("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n"),
    HOW_MANY_MANUAL("수동으로 구매할 로또 수를 입력해 주세요."),
    ENTER_MANUAL_NUM("수동으로 구매할 번호를 입력해 주세요."),
    LAST_WINNING_NUM("\n지난 주 당첨 번호를 입력해주세요."),
    BONUS_NUM("보너스 볼을 입력해 주세요."),
    WIN_RATE("총 수익률은 %d%%입니다.");

    private final String message;

    UIMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
