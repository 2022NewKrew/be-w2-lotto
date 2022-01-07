package com.cold.models;

import com.cold.domain.Rank;
import lombok.Getter;

import java.util.Map;

@Getter
public class LottosResult {
    private static String RESULT_STATISTICS = "%d개 일치 (%d원)- %d개\n";
    private static String RESULT_STATISTICS_BONUS_CASE = "5개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static String MAP_BONUS_MATCH_KEY = "BONUS";

    public String message;
    public Double totalRateOfReturn;

    public LottosResult(WholeTickets wholeTickets) {
        setMessage(wholeTickets.getWholeResult());
        this.totalRateOfReturn = wholeTickets.getProfitRate();
    }

    public void setMessage(Map<String, Integer> wholeResult) {
        message = "";
        addEachTicketResult(wholeResult);
    }

    private void addEachTicketResult(Map<String, Integer> wholeResult) {
        for (String key : wholeResult.keySet()) {
            message += addEachCase(key, wholeResult.get(key));
        }
    }

    private String addEachCase(String match, Integer value) {
        if (match.equals(MAP_BONUS_MATCH_KEY)) {
            return String.format(RESULT_STATISTICS_BONUS_CASE,
                    Rank.valueOf(match).getWinningReward(), value);
        }

        return String.format(RESULT_STATISTICS,
                Rank.valueOf(match).getMatchCount(),
                Rank.valueOf(match).getWinningReward(), value);
    }
}
