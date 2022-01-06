package com.david.lotto;

import com.david.lotto.web.LottoWebInput;

import java.util.List;

public class LottoMachine {

    public static int lottoPrice = 1000;
    private static final LottoWebInput lottoWebInput = new LottoWebInput();
    private final List<Lotto> lottoList;
    private final LottoCalculate lottoCalculate = new LottoCalculate();
    private String profitRate;

    public LottoMachine(String inputMoney, String manualNumber) {
        int amount = lottoWebInput.convertToInt(inputMoney);
        this.lottoList = lottoWebInput.convertToLottoList(manualNumber, amount);
    }

    public String getProfitRate() {
        return profitRate;
    }

    public LottoCalculate getLottoCalculate() {
        return lottoCalculate;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void calculateResult(String inputWinningNumber, String inputBonusNumber) {
        List<Integer> winningNumber = lottoWebInput.convertToNumberList(inputWinningNumber);
        int bonusNumber = lottoWebInput.convertToInt(inputBonusNumber);
        int countOfLotto = lottoList.size();
        profitRate = String.format("%.2f", lottoCalculate.calculateProfitRate(lottoList, winningNumber, countOfLotto, bonusNumber));
    }

}
