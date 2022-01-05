package view;

public enum Guide {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_MANUAL_LOTTO_NUM("수동으로 구매할 로또 수를 입력해 주세요."),
    INPUT_MANUAL_NUMS("수동으로 구매할 번호를 입력해 주세요."),
    INPUT_WINNING_NUMS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_WINNING_BONUS("보너스 볼을 입력해 주세요.");

    private final String guideString;

    Guide(String s) {
        this.guideString = s;
    }

    @Override
    public String toString() {
        return guideString;
    }
}
