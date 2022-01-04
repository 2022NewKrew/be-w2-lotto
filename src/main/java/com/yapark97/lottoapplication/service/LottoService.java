package com.yapark97.lottoapplication.service;

import com.yapark97.lottoapplication.domain.lotto.LottoConst;
import com.yapark97.lottoapplication.domain.lotto.LottoSet;
import com.yapark97.lottoapplication.domain.lotto.WinningLotto;
import com.yapark97.lottoapplication.domain.winningPolicy.BonusBallWinningPolicy;
import com.yapark97.lottoapplication.domain.winningPolicy.SimpleWinningPolicy;
import com.yapark97.lottoapplication.domain.winningPolicy.WinningPolicy;
import com.yapark97.lottoapplication.view.LottoInput;
import com.yapark97.lottoapplication.view.LottoOutput;
import com.yapark97.lottoapplication.view.SimpleLottoInput;
import com.yapark97.lottoapplication.view.SimpleLottoOutput;

import java.util.*;

public class LottoService {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    private LottoSet lottoSet;
    private WinningLotto winningLotto;
    private Set<WinningPolicy> winningPolicies;

    public LottoService() {
        // Standart input/output 사용한 view 클래스
        this.lottoInput = SimpleLottoInput.getInstance();
        this.lottoOutput = SimpleLottoOutput.getInstance();
    }

    public void run() {
        initLottoSet();
        initWinningPolicy();
        showLottoSet();
        initWinnintLotto();
        showStatistic();
    }

    private void initLottoSet() {
        int lottoSetNum = lottoInput.takeLottoSetNumInput();

        lottoSet = new LottoSet(lottoSetNum);
    }

    private void initWinningPolicy() {
        winningPolicies = new TreeSet<>(); // 상금 순서로 정렬된 set

        for (int i=0; i< LottoConst.WINNING_CONDITION.size(); i++) {
            winningPolicies.add(new SimpleWinningPolicy(LottoConst.WINNING_CONDITION.get(i), LottoConst.WINNING_PRIZE.get(i)));
        }
    }

    private void showLottoSet() {
        lottoOutput.printLottoSetInfo(lottoSet);
    }

    private void initWinnintLotto() {
        List<Integer> winningNumbers = lottoInput.takeWinningNumbersInput();
        int bonusBall = lottoInput.takeBonusBallInput();
        winningLotto = new WinningLotto(winningNumbers, bonusBall);
        addBonusBallWinningPolicy(bonusBall);
    }

    private void addBonusBallWinningPolicy(int bonusBall) {
        winningPolicies.add(new BonusBallWinningPolicy(bonusBall, LottoConst.BONUS_BALL_WINNING_CONDITION, LottoConst.BONUS_BALL_WINNING_PRIZE));
    }

    private void showStatistic() {
        Map<WinningPolicy, Integer> statistic = new LinkedHashMap<>(); // 순서 유지

        for (WinningPolicy winningPolicy : winningPolicies) {
            int count = (int) lottoSet.getLottos().stream()
                    .filter(lotto -> winningPolicy.isWon(lotto, winningLotto))
                    .count();
            statistic.put(winningPolicy, count);
        }
        lottoOutput.printStatistic(statistic);
        showProfitRate(statistic);
    }

    private void showProfitRate(Map<WinningPolicy, Integer> statistic) {
        int profit = 0;

        for (WinningPolicy winningPolicy : winningPolicies) {
            profit += winningPolicy.getWinningPrize() * statistic.get(winningPolicy);
        }
        lottoOutput.printProfitRate(getProfitRate(profit));
    }

    private double getProfitRate(int profit) {
        double price = lottoSet.getLottoSetSize() * 1000;
        double profitRate = (profit - price) / price * 100;

        return Math.round(profitRate * 100) / 100.0;
    }
}
