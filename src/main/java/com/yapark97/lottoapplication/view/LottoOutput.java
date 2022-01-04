package com.yapark97.lottoapplication.view;

import com.yapark97.lottoapplication.domain.lotto.LottoSet;
import com.yapark97.lottoapplication.domain.winningPolicy.WinningPolicy;

import java.util.Map;

public interface LottoOutput {
    void printLottoSetInfo(LottoSet lottoSet);
    void printStatistic(Map<WinningPolicy, Integer> statistic);
}
