package com.meg.w2lotto.service;

import com.meg.w2lotto.domain.lotto.LastWinningLotto;
import com.meg.w2lotto.domain.lotto.Lotto;
import com.meg.w2lotto.domain.lotto.LottoPack;
import com.meg.w2lotto.domain.result.Result;
import com.meg.w2lotto.domain.result.Statistic;

import java.util.List;

public class ResultService {

    private static ResultService INSTANCE;

    private ResultService() {}

    public static ResultService getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new ResultService();
        }
        return INSTANCE;
    }

    public Statistic createStatistic(List<Integer> winningLotto, int bonusBall, LottoPack lottoPack) {

        Statistic statistic = new Statistic(lottoPack.getPrice());
        for (Lotto lotto : lottoPack.getLottos()) {
            Result result = new Result(new LastWinningLotto(winningLotto, bonusBall), lotto);
            statistic.addUpCorrectCounts(result.getPrize());
        }
        statistic.calculateTotalReturn();
        return statistic;
    }

}
