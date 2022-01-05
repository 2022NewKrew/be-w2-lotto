package lotto.constant;
public enum Msg {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요."),

    OUTPUT_RANK("%d개 일치 (%d원)- %d개"),
    OUTPUT_RANK_2ND("%d개, 보너스 볼 일치 (%d원)- %d개")
    ;

    private final String msg;

    Msg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
