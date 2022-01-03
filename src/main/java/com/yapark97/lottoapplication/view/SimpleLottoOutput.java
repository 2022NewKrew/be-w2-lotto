package com.yapark97.lottoapplication.view;

import com.yapark97.lottoapplication.domain.Lotto;
import com.yapark97.lottoapplication.domain.LottoConst;
import com.yapark97.lottoapplication.domain.LottoSet;

import java.util.Map;

public class SimpleLottoOutput implements LottoOutput{
    private static final SimpleLottoOutput simpleLottoOutput = new SimpleLottoOutput();

    // 싱글톤 패턴
    private SimpleLottoOutput() {}

    public static SimpleLottoOutput getInstance() {
        return simpleLottoOutput;
    }

    @Override
    public void printLottoSetInfo(LottoSet lottoSet) {
        System.out.println(lottoSet);
    }

    @Override
    public void printStatistic(Map<Integer, Integer> statistic) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (int i=0; i<LottoConst.WINNING_CONDITION.size(); i++) {
            int winningCondition = LottoConst.WINNING_CONDITION.get(i);
            int winningPrize = LottoConst.WINNING_PRIZE.get(i);

            System.out.println(winningCondition + "개 일치 (" + winningPrize + ")- " + statistic.getOrDefault(winningCondition, 0) + "개");
        }
    }
}
