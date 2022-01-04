package com.meg.w2lotto.domain;

import com.meg.w2lotto.view.InputView;
import com.meg.w2lotto.view.OutputView;

import java.util.*;

public class LottoGame {

    private int purchaseMoney;
    private List<Lotto> lottos;
    private List<Integer> correctNumbers;
    private int bonusBall;
    private final Map<Prize, Integer> correctCountsWithPrize = new HashMap<>();

    public LottoGame() {
    }

    public final void start() {

        generateLottos();
        showLottos();
        generateCorrectNumbers();
        showResult();

    }

    private final void generateLottos() {
        purchaseMoney = InputView.askPurchaseAmount();
        lottos = new ArrayList<>(purchaseMoney / Lotto.COST);
        for (int i = 0; i < purchaseMoney / Lotto.COST; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
        OutputView.printPurchaseMessage(lottos.size());
    }

    private final void showLottos() {
        for (int i = 0; i < lottos.size(); i++) {
            OutputView.printLottoNumber(lottos.get(i).getNumbers());
        }
    }

    private final void generateCorrectNumbers() {
        correctNumbers = InputView.askLastLottoNumbers();
        bonusBall = InputView.askBonusBallNumber();
    }

    private final void showResult() {
        calculateCorrectCounts();
        OutputView.printResult(correctCountsWithPrize);
        OutputView.printRateOfReturn(calculateRateOfReturn());
    }

    private final void calculateCorrectCounts() {
        setCorrectCountsWithPrize();
        for (Lotto lotto : lottos) {
            Prize prize = Prize.valueOf(getCorrectCountsOfLotto(lotto), containBonusBall(lotto));
            addUpCorrectCount(prize);
        }
    }

    private final void setCorrectCountsWithPrize() {
        for (Prize prize : Prize.values()) {
            correctCountsWithPrize.put(prize, 0);
        }
    }

    private final int getCorrectCountsOfLotto(Lotto lotto) {
        int cnt = 0;
        for (int lnum : correctNumbers) {
            if (lotto.contains(lnum)) cnt += 1;
        }
        return cnt;
    }

    private final boolean containBonusBall(Lotto lotto) {
        return lotto.contains(bonusBall);
    }

    private final void addUpCorrectCount(Prize prize) {
        if (prize != null) {
            correctCountsWithPrize.put(prize, correctCountsWithPrize.get(prize) + 1);
        }
    }

    private final int calculateRateOfReturn() {
        int totalReturn = 0;
        for (Map.Entry<Prize, Integer> entry : correctCountsWithPrize.entrySet()) {
            totalReturn += (entry.getKey().getWinningMoney() * entry.getValue());
        }
        System.out.println(totalReturn);
        return (totalReturn-purchaseMoney) / purchaseMoney * 100;
    }

}
