package lotto.domain;

public enum OutputViewMessage {
    OUTPUT_PURCHASE_COUNT("%d개를 구매했습니다.\n"),
    OUTPUT_TITLE("\n당첨 통계\n"),
    OUTPUT_DIVIDING_LINE("---------\n"),
    OUTPUT_MATCHES("%d개 일치 (%d원) - %d개\n"),
    OUTPUT_BONUS_BALL_MATCH("5개 일치, 보너스 볼 일치(%d원) - %d개\n"),
    OUTPUT_TOTAL_RATE_OF_RETURN("총 수익률은 %.2f%%입니다.\n");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
