package lotto.domain;

import lotto.constant.WinningType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static lotto.constant.Constants.*;
import static lotto.view.IOView.*;

public class LottoGame {

    private final List<Lotto> purchasedLottoList;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final Map<Integer, Long> lotteryResult;
    private long profit;

    public LottoGame(List<Lotto> purchasedLottoList, List<Integer> winningNumbers, int bonusNumber) {
        this.purchasedLottoList = purchasedLottoList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lotteryResult = new HashMap<>();
    }

    public static void run() {
        long purchaseAmount = inputPurchaseAmount();
        List<Lotto> purchasedLottoList = purchaseLotto(purchaseAmount);
        printLottoList(purchasedLottoList, purchaseAmount);

        List<Integer> winningNumbers = inputWinningNumber();
        int bonusNumber = inputBonusNumber();
        LottoGame lottoGame = new LottoGame(purchasedLottoList, winningNumbers, bonusNumber);
        lottoGame.makeResult();

        printLottoResult(lottoGame);
    }

    private void makeResult() {
        List<Integer> correctResult = this.purchasedLottoList.stream()
                                                                        .map(lotto -> lotto.getResult(this))
                                                                        .filter(matched -> matched >= MIN_MATCHING_NUM_TO_WINNING)
                                                                        .collect(Collectors.toList());

        this.setResult(correctResult);
    }

    private void setResult(List<Integer> correctResult) {
        this.profit = 0;
        IntStream.rangeClosed(MIN_MATCHING_NUM_TO_WINNING, MAX_MATCHING_NUM_TO_WINNING).forEach(
                correct -> {
                                this.lotteryResult.put(correct, this.getNumOfCorrect(correctResult, correct));
                                this.profit += this.lotteryResult.getOrDefault(correct, 0L) * (long) WinningType.findType(correct).getPrizeMoney();
                            });
    }

    private long getNumOfCorrect(List<Integer> correctResult, int correct) {
        return  correctResult.stream()
                                        .filter(num -> num == correct)
                                        .count();
    }

    private static List<Lotto> purchaseLotto(long purchaseAmount) {
        List<Lotto> randomLottoList = purchaseRandomLotto(purchaseAmount);

        return new ArrayList<>(randomLottoList);
    }



    private static List<Lotto> purchaseRandomLotto(long purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        LongStream.range(0L, purchaseAmount)
                .forEach(i -> {
                    Lotto newLotto = Lotto.createRandomLotto();
                    lottoList.add(newLotto);
                });

        return lottoList;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public Map<Integer, Long> getLotteryResult() {
        return this.lotteryResult;
    }

    public double getEarningRate() {
        long purchaseMoney = this.purchasedLottoList.size() * (long) PRICE_OF_LOTTO;
        long gain = profit - purchaseMoney;

        double earningRate = (double) purchaseMoney / gain;

        return earningRate * 100;
    }
}
