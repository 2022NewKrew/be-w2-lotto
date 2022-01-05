package com.cold.view;

import com.cold.domain.Prices;
import com.cold.domain.SingleTicket;
import com.cold.domain.WholeTickets;

import java.util.Map;

public class OutputView {
    private static String PURCHASE_NOTICE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";
    private static String RESULT_STATISTICS = "%d개 일치 (%d원)- %d개\n";
    private static String RESULT_STATISTICS_BONUS_CASE = "5개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static String RESULT_BANNER = "당첨통계\n";
    private static String HORIZONTAL_LINE = "---------\n";
    private static String PROFIT_RATE = "총 수익률은 %.2f%%입니다.\n";
    private static String MAP_BONUS_MATCH_KEY = "BONUS";
    private static int[] MAP_TRAVERSE_ORDER = {3, 4, 5, 7, 6};


    public static void printPurchaseResult(WholeTickets wholeTickets, int autoLottoCount, int manualLottoCount) {
        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format(PURCHASE_NOTICE, manualLottoCount, autoLottoCount));
        for (SingleTicket ticket : wholeTickets.getTickets()) {
            outputString.append(ticket.getNumbers() + "\n");
        }
        System.out.println(outputString);
    }

    public static void printGameResult(WholeTickets wholeTickets) {
        printResultStatistics(wholeTickets.getWholeResult());
        printProfitRate(wholeTickets.getProfitRate());
    }

    private static void printProfitRate(Double profitRate) {
        System.out.printf(PROFIT_RATE, profitRate);
    }

    private static void printResultStatistics(Map<String, Integer> wholeResult) {
        StringBuilder outputString = new StringBuilder();
        outputString = addBannerString(outputString);
        outputString = addEachTicketResult(wholeResult, outputString);
        System.out.println(outputString);
    }

    private static StringBuilder addBannerString(StringBuilder outputString) {
        outputString.append(RESULT_BANNER);
        outputString.append(HORIZONTAL_LINE);
        return outputString;
    }

    private static StringBuilder addEachTicketResult(Map<String, Integer> wholeResult, StringBuilder outputString) {
        for (String key : wholeResult.keySet()) {
            outputString.append(addEachCase(key, wholeResult.get(key)));
        }
        return outputString;
    }

    private static String addEachCase(String match, Integer value) {
        if (match == MAP_BONUS_MATCH_KEY) {
            return String.format(RESULT_STATISTICS_BONUS_CASE,
                    Prices.valueOf(match).getWinningReward(), value);
        }

        return String.format(RESULT_STATISTICS,
                Prices.valueOf(match).getMatchCount(),
                Prices.valueOf(match).getWinningReward(), value);
    }
}
