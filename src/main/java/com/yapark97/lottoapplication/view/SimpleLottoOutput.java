package com.yapark97.lottoapplication.view;

import com.yapark97.lottoapplication.domain.lotto.LottoSet;
import com.yapark97.lottoapplication.domain.winningPolicy.WinningPolicy;

import java.util.Map;

public class SimpleLottoOutput implements LottoOutput{
    private static final SimpleLottoOutput simpleLottoOutput = new SimpleLottoOutput();

    // 싱글톤 클래스
    private SimpleLottoOutput() {}

    public static SimpleLottoOutput getInstance() {
        return simpleLottoOutput;
    }

    @Override
    public void printLottoSetInfo(LottoSet lottoSet) {
        System.out.println(lottoSet);
    }

    @Override
    public void printStatistic(Map<WinningPolicy, Integer> statistic) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (WinningPolicy winningPolicy : statistic.keySet()) {
            System.out.println( winningPolicy + "- " + statistic.get(winningPolicy) + "개");
        }
    }

    @Override
    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
