package com.meg.w2lotto.domain;

import com.meg.w2lotto.view.InputView;
import com.meg.w2lotto.view.OutputView;

import java.util.*;

public class LottoGame {

    private int purchaseMoney;
    private List<Lotto> lottos;
    private LastWinningLotto lastWinningLotto;
    private final Map<Prize, Integer> correctCountsWithPrize = new HashMap<>();

    public LottoGame() {
    }

    public final void start() {

        generateLottos();
        showLottos();
        generateCorrectNumbers();
        showResult();

    }

    private void generateLottos() {
        purchaseMoney = InputView.askPurchaseMoney();
        int lottoCount = purchaseMoney / Lotto.COST;
        int manualLottoCount = InputView.askPurchaseManualLottoCount();
        lottos = new ArrayList<>(lottoCount);
        createManualLotto(manualLottoCount);
        createAutolLotto(lottoCount - manualLottoCount);
        OutputView.printPurchaseMessage(manualLottoCount, lottoCount - manualLottoCount);

    }

    private void createManualLotto(int manualLottoCount) {
        for (int i = 0; i < manualLottoCount; i++) {
            List<Integer> manualLottoNumbers = InputView.askPurchaseManualLottoNumbers();
            lottos.add(LottoFactory.createManualLotto(manualLottoNumbers));
        }
    }

    private void createAutolLotto(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
    }

    private void showLottos() {
        for (Lotto lotto : lottos) {
            OutputView.printLottoNumber(lotto);
        }
    }

    private void generateCorrectNumbers() {
        lastWinningLotto = LottoFactory.createLastWinningLotto(InputView.askLastLottoNumbers(), InputView.askBonusBallNumber());
    }

    private void showResult() {
        calculateCorrectCounts();
        OutputView.printResult(correctCountsWithPrize);
        OutputView.printRateOfReturn(calculateRateOfReturn());
    }

    private void calculateCorrectCounts() {
        setCorrectCountsWithPrize();
        for (Lotto lotto : lottos) {
            Prize prize = Prize.valueOf(getCorrectCountsOfLotto(lotto), containBonusBall(lotto));
            addUpCorrectCount(prize);
        }
    }

    private void setCorrectCountsWithPrize() {
        for (Prize prize : Prize.values()) {
            correctCountsWithPrize.put(prize, 0);
        }
    }

    private int getCorrectCountsOfLotto(Lotto lotto) {
        int cnt = 0;
        for (LottoNumber num : lastWinningLotto.getNumbers()) {
            if (lotto.contains(num)) cnt += 1;
        }
        return cnt;
    }

    private boolean containBonusBall(Lotto lotto) {
        return lotto.contains(lastWinningLotto.getBonusBall());
    }

    private void addUpCorrectCount(Prize prize) {
        if (prize != null) {
            correctCountsWithPrize.put(prize, correctCountsWithPrize.get(prize) + 1);
        }
    }

    private int calculateRateOfReturn() {
        int totalReturn = 0;
        for (Map.Entry<Prize, Integer> entry : correctCountsWithPrize.entrySet()) {
            totalReturn += (entry.getKey().getWinningMoney() * entry.getValue());
        }
        return (totalReturn - purchaseMoney) / purchaseMoney * 100;
    }

}
