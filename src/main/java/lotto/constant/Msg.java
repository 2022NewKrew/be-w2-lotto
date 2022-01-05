package lotto.constant;
public enum Msg {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    ;

    private final String msg;

    Msg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
