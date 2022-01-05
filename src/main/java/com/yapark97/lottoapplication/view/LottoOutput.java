package com.yapark97.lottoapplication.view;

import com.yapark97.lottoapplication.domain.lotto.LottoSet;
import com.yapark97.lottoapplication.domain.winningPolicy.WinningPolicy;

import java.util.Map;

public interface LottoOutput {
    void printLottoSetInfo(int manualLottoNum, int randomLottoNum, LottoSet lottoSet);

    void printStatistic(Map<WinningPolicy, Integer> statistic);

    void printProfitRate(double profitRate);
}
