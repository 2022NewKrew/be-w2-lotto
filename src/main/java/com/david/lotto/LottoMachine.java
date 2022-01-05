package com.david.lotto;

import com.david.lotto.validation.LottoNumberGenerator;
import com.david.lotto.view.LottoInput;
import com.david.lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final LottoInput lottoInput = new LottoInput();
    private static final LottoOutput lottoOutput = new LottoOutput();
    private static final LottoCalculate lottoCalculate = new LottoCalculate();
    public static final int lottoPrice = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();

    private void generateLottoList(int countOfLotto, int manualCount, List<List<Integer>> manualLottoList) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        for (List<Integer> lottoNumber : manualLottoList) {
            lottoList.add(new Lotto(lottoNumber));
        }
        int autoCount = countOfLotto - manualCount;
        for (int i = 0; i < autoCount; i++) {
            List<Integer> lottoNumber = lottoNumberGenerator.generateLottoNumber();
            lottoList.add(new Lotto(lottoNumber));
        }
    }

    public void runLottoMachine() {
        int amount = lottoInput.inputAmount();
        int countOfLotto = amount / lottoPrice;
        int manualCount = lottoInput.inputManualCount(amount);
        int autoCount = countOfLotto - manualCount;
        List<List<Integer>> manualLottoList = lottoInput.inputLottoNumber(manualCount);
        generateLottoList(countOfLotto, manualCount, manualLottoList);
        lottoOutput.printLottoCount(manualCount, autoCount);
        lottoOutput.printLottoInfo(lottoList);
        List<Integer> winningNumber = lottoInput.inputWinningNumber();
        int bonusNumber = lottoInput.inputBonusNumber(winningNumber);
        double profitRate = lottoCalculate.calculateProfitRate(lottoList, winningNumber, countOfLotto, bonusNumber);
        lottoOutput.printLottoResult(lottoCalculate, profitRate);
    }
}
