package step1.view;

import step1.domain.WinRankInform;

import java.util.List;

public class ResultPrinter {

    private static final String PREFIX_MATCH_MESSAGE = "개 일치 (";
    private static final String SUFFIX_MATCH_MESSAGE = "원)- ";
    private static final String PREFIX_TOTAL_RATE_MESSAGE = "총 수익률은 ";
    private static final String SUFFIX_TOTAL_RATE_MESSAGE = "%입니다.";
    private static final String WIN_STAT_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "---------";
    private static final String COUNTER = "개";

    public static void printWinStats(List<WinRankInform> winRankInforms) {
        System.out.println(WIN_STAT_MESSAGE);
        System.out.println(DIVIDER);

        for (WinRankInform winRankInform : winRankInforms) {
            printRank(winRankInform);
        }
    }

    private static void printRank(WinRankInform winRankInform) {
        System.out.println(winRankInform.getMatchCondition()
                + PREFIX_MATCH_MESSAGE
                + winRankInform.getReward()
                + SUFFIX_MATCH_MESSAGE
                + winRankInform.getWinCount()
                + COUNTER);
    }

    public static void printEarningRate(int rate) {
        System.out.println(PREFIX_TOTAL_RATE_MESSAGE + rate + SUFFIX_TOTAL_RATE_MESSAGE);
    }
}
