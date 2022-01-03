package com.david.lotto.domain;

import com.david.lotto.view.LottoInput;
import com.david.lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final LottoInput lottoInput = new LottoInput();
    private static final LottoOutput lottoOutput = new LottoOutput();
    private static final LottoCalculate lottoCalculate = new LottoCalculate();
    private static final int lottoPrice = 1000;
    private final List<Lotto> lottoList = new ArrayList<>();
    private int count;

    private void generateLottoList() {
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }

    public void runLottoMachine() {
        int amount = lottoInput.inputAmount();
        lottoOutput.printLottoCount(amount,lottoPrice);
        count = amount / lottoPrice;
        generateLottoList();
        lottoOutput.printLottoInfo(this);
        List<Integer> winningNumber = lottoInput.inputWinningNumber();
        double profitRate = lottoCalculate.calculateProfitRate(lottoList, winningNumber, amount);
        lottoOutput.printLottoResult(lottoCalculate, profitRate);
    }

    @Override
    public String toString() {
        return lottoList.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
