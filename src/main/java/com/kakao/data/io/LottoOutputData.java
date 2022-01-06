package com.kakao.data.io;

public class LottoOutputData {

    private LottoOutputData(){}

    public static final String RESULT_COMMENT_OF_PURCHASE = "%d개를 구매했습니다.\n";

    public static final String RESULT_COMMENT_OF_WINNING = "당첨 통계\n";
    public static final String RESULT_DIVISION_LINE_OF_WINNING = "---------\n";

    public static final String RESULT_FORMAT_OF_WINNING_MATCH = "%d개 일치 (%d원)- %d\n";
    public static final String RESULT_FORMAT_OF_WINNING_MATCH_WITH_BONUS_BALL = "%d개 일치, 보너스 볼 일치 (%d원)- %d\n";

    public static final String RESULT_FORMAT_OF_YIELD_RATE = "총 수익률을 %3d%%입니다.\n";
}
