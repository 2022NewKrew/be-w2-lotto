package com.cold.view;

import com.cold.domain.GameLogic;
import com.cold.domain.Prices;
import com.cold.domain.SingleTicket;
import com.cold.domain.WholeTickets;

import java.util.Map;

public class OutputView {
    private static String PURCHASE_NOTICE = "개를 구매했습니다.\n";
    private static String RESULT_STATISTICS = "%d개 일치 (%d원)- %d개\n";
    private static String RESULT_STATISTICS_BONUS_CASE = "5개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static String RESULT_BANNER = "당첨통계\n";
    private static String HORIZONTAL_LINE = "---------\n";
    private static String PROFIT_RATE = "총 수익률은 %.2f%%입니다.\n";
    private static Integer MAP_BONUS_MATCH_KEY = 7;
    private static int[] MAP_TRAVERSE_ORDER = {3, 4, 5, 7, 6};


    public static void printPurchaseResult(WholeTickets wholeTickets, int purchasedCount) {
        StringBuilder outputString = new StringBuilder();
        outputString.append(purchasedCount + PURCHASE_NOTICE);
        for (SingleTicket ticket : wholeTickets.getTickets()) {
            outputString.append(ticket.getNumbers() + "\n");
        }
        System.out.println(outputString);
    }

    public static void printGameResult(GameLogic gameLogic) throws Exception {
        printResultStatistics(gameLogic);
        printProfitRate(gameLogic);
    }

    private static void printProfitRate(GameLogic gameLogic) {
        System.out.printf(PROFIT_RATE, gameLogic.getProfitRate());
    }

    private static void printResultStatistics(GameLogic gameLogic) throws Exception {
        StringBuilder outputString = new StringBuilder();
        outputString = addBannerString(outputString);
        outputString = addEachTicketResult(gameLogic.getResult(), outputString);
        System.out.println(outputString);
    }

    private static StringBuilder addBannerString(StringBuilder outputString) {
        outputString.append(RESULT_BANNER);
        outputString.append(HORIZONTAL_LINE);
        return outputString;
    }

    private static StringBuilder addEachTicketResult(Map<Integer, Integer> result, StringBuilder outputString)
            throws Exception {
        for (Integer key : MAP_TRAVERSE_ORDER) {
            outputString.append(addEachCase(key, result.get(key)));
        }
        return outputString;
    }

    private static String addEachCase(Integer match, Integer value) throws Exception {
        if (match == MAP_BONUS_MATCH_KEY) {
            return String.format(RESULT_STATISTICS_BONUS_CASE,
                    Prices.values()[match - 3].getWinningReward(), value);
        }

        return String.format(RESULT_STATISTICS,
                Prices.values()[match - 3].getMatchValue(),
                Prices.values()[match - 3].getWinningReward(), value);
    }
}
