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
    private final ArrayList<Integer> rewards = new ArrayList<>(Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000));
    private final ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
    private final int price = 1000;
    private int money;
    private int count;


    public void startGamble () {
        money = lottoInput.moneyInput();
        count = money / price;
        generateLottoList();
        lottoOutput.printLottoList(lottoList);
        winningNumbers = lottoInput.winningNumbersInput();
        checkLottoNumber();
        lottoOutput.printResult(rewards, results, money);
    }

    private void generateLottoList() {
        for (int i = 0; i < count; i++) {
            lottoList.add(new LottoNumbers());
        }
    }

    private void checkLottoNumber() {
        for (LottoNumbers lotto : lottoList) {
            int count = lotto.calculateContain(winningNumbers);
            results.set(count, results.get(count) + 1);
        }
    }
}
