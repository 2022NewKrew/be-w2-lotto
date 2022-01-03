package com.meg.w2lotto.domain;

import com.meg.w2lotto.view.InputView;
import com.meg.w2lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private int purchaseAmount;
    private List<Lotto> lottos;
    private List<Integer> correctCounts;
    private List<Integer> correctNumbers;
    private final List<Integer> prizes = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    public LottoGame() {
    }

    public void start() {

        generateLottos();
        showLottos();
        generateCorrectNumbers();
        showResult();

    }

    private void generateLottos() {
        purchaseAmount = InputView.askPurchaseAmount();
        lottos = new ArrayList<>(purchaseAmount / Lotto.COST);
        System.out.println(purchaseAmount / Lotto.COST);
        for (int i = 0; i < purchaseAmount / Lotto.COST; i++) {
            lottos.add(new Lotto());
        }
        OutputView.printPurchaseMessage(lottos.size());
    }

    private void showLottos() {
        for (int i = 0; i < lottos.size(); i++) {
            OutputView.printLottoNumber(lottos.get(i).getNumbers());
        }
    }

    private void generateCorrectNumbers() {
        correctNumbers = InputView.askLastLottoNumber();
    }

    private void showResult() {
        calculateCorrectCounts();
        OutputView.printResult(prizes, correctCounts);
        OutputView.printRateOfReturn(calculateRateOfReturn());
    }

    private void calculateCorrectCounts() {
        correctCounts = new ArrayList<>(Collections.nCopies(Lotto.NUMCOUNT + 1, 0));
        for (Lotto lotto : lottos) {
            int cnt = getCorrectCountsOfLotto(lotto);
            correctCounts.set(cnt, correctCounts.get(cnt) + 1);
        }
    }

    private int getCorrectCountsOfLotto(Lotto lotto) {
        int cnt = 0;
        for (int lnum : correctNumbers) {
            if (lotto.contains(lnum)) cnt += 1;
        }
        return cnt;
    }

    private int calculateRateOfReturn() {
        int totalReturn = 0;
        for (int i = 3; i <= Lotto.NUMCOUNT; i++) {
            totalReturn += (prizes.get(i) * correctCounts.get(i));
        }
        return totalReturn / purchaseAmount * 100;
    }

}
