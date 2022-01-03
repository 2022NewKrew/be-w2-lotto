package com.yapark97.lottoapplication.view;

import com.yapark97.lottoapplication.domain.Lotto;
import com.yapark97.lottoapplication.domain.LottoSet;

import java.util.Map;

public interface LottoOutput {
    void printLottoSetInfo(LottoSet lottoSet);
    void printStatistic(Map<Integer, Integer> statistic);
}
