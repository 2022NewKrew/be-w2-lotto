package com.david.lotto;

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
    private int count;

    private void generateLottoList() {
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }

    public void runLottoMachine() {
        count = lottoInput.inputCount(lottoPrice);
        lottoOutput.printLottoCount(count);
        generateLottoList();
        lottoOutput.printLottoInfo(lottoList);
        List<Integer> winningNumber = lottoInput.inputWinningNumber();
        int bonusNumber = lottoInput.inputBonusNumber();
        double profitRate = lottoCalculate.calculateProfitRate(lottoList, winningNumber, count, bonusNumber);
        lottoOutput.printLottoResult(lottoCalculate, profitRate);
    }
}
