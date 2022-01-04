package lotto.domain;

import lotto.constant.WinningType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.Constants.*;

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

    public void makeResult() {
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
        long purchaseMoney = (long) this.purchasedLottoList.size() * PRICE_OF_LOTTO;
        long gain = profit - purchaseMoney;

        double earningRate = (double) gain / purchaseMoney;

        return earningRate * 100;
    }
}
