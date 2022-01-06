package lotto.domain;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMain {
    private final LottoInput lottoInput = new LottoInput();
    private final LottoOutput lottoOutput = new LottoOutput();
    private final List<LottoNumbers> lottoList = new ArrayList<>();
    private ArrayList<Integer> winningNumbers;
    private int bonusNumber;
    private final ArrayList<Integer> rewards = new ArrayList<>(Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000));
    private final ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
    private final int price = 1000;
    private int money;
    private int autoCount;


    public void startGamble () {
        money = lottoInput.moneyInput();
        autoCount = money / price;
        generateUserInputLotto();
        generateAutoLottoList();
        lottoOutput.printLottoList(lottoList, autoCount);
        winningNumbers = lottoInput.winningNumbersInput();
        bonusNumber = lottoInput.bonusNumberInput();
        checkLottoNumber();
        lottoOutput.printResult(rewards, results, money);
    }

    private void generateUserInputLotto() {
        int count = lottoInput.selectCountInput();
        autoCount -= count;
        lottoInput.userInputLottoNumbers(lottoList, count);
    }

    private void generateAutoLottoList() {
        for (int i = 0; i < autoCount; i++) {
            lottoList.add(new LottoNumbers());
        }
    }

    private void checkLottoNumber() {
        for (LottoNumbers lotto : lottoList) {
            int count = lotto.calculateContain(winningNumbers, bonusNumber);
            results.set(count, results.get(count) + 1);
        }
    }
}
