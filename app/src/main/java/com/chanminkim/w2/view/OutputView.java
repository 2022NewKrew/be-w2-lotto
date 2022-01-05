package com.chanminkim.w2.view;

import com.chanminkim.w2.model.Lotto;
import com.chanminkim.w2.model.WinningState;
import com.chanminkim.w2.model.WinningStatistics;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchasedLottoList(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printWinningStatistics(WinningStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printMatchedList(statistics);
        System.out.printf("총 수익률은 %.2f%% 입니다.%n", statistics.calculateEarningPercentage());
    }

    private void printMatchedList(WinningStatistics statistics) {
        for (Map.Entry<WinningState, Integer> entry : statistics.getCountMap().entrySet()) {
            WinningState state = entry.getKey();
            int count = entry.getValue();
            String bonusString = ", 보너스 볼 일치";
            System.out.printf("%d개 일치%s(%d원) - %d개%n",
                    state.getMatchedCount(),
                    state.isCountingBonus() ? bonusString : "",
                    state.getPrizeMoney(),
                    count);
        }
    }
}
