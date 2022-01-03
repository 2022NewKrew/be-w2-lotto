package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static lotto.constant.Constants.*;
import static lotto.util.RandomNumberCreator.createRandomNumbers;
import static lotto.view.InputProcessor.*;

public class Lotto {

    private final List<LottoNumber> purchasedLottoNumberList;
    private final List<Integer> winningNumbers;
    private final Map<Integer, Long> lotteryResult;
    private long profit;

    public Lotto(List<LottoNumber> purchasedLottoNumberList, List<Integer> winningNumbers) {
        this.purchasedLottoNumberList = purchasedLottoNumberList;
        this.winningNumbers = winningNumbers;
        this.lotteryResult = new HashMap<>();
    }

    public static void run() {
        List<LottoNumber> purchasedLottoNumberList = purchaseLotto();
        List<Integer> winningNumbers = inputWinningNumber();
        Lotto lotto = new Lotto(purchasedLottoNumberList, winningNumbers);
        System.out.println(lotto);
        lotto.makeResult();
        lotto.printResult();
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();
        long earningRate = (long) ( ( (double) this.profit / ( (double) this.purchasedLottoNumberList.size() * PRICE_OF_LOTTO) ) * 100 );
        sb.append(RESULT_TITLE).append(NEW_LINE);
        sb.append(PARTITION).append(NEW_LINE);
        IntStream.rangeClosed(MIN_NUM_TO_WINNING, NUM_OF_WINNING_NUMBERS)
                .forEach(num -> sb.append(String.format(WINNING_MESSAGE_FORMAT, NUMBER_MATCH.get(num), PRIZE_MONEYS.get(num), this.lotteryResult.get(num))).append(NEW_LINE));
        sb.append(EARNING_RATE_MSG_LEFT);
        sb.append(earningRate);
        sb.append(EARNING_RATE_MSG_RIGHT_FORMAT);

        System.out.println(sb);
    }

    private void makeResult() {
        List<Integer> correctResult = this.purchasedLottoNumberList.stream()
                .map(lottoNumber -> lottoNumber.getResult(this.winningNumbers))
                .filter(matched -> matched >= MIN_NUM_TO_WINNING)
                .collect(Collectors.toList());

        this.profit = 0;
        IntStream.rangeClosed(MIN_NUM_TO_WINNING, NUM_OF_WINNING_NUMBERS)
                .forEach(correct -> {
                    this.lotteryResult.put(correct, this.getNumOfCorrect(correctResult, correct));
                    this.profit += this.lotteryResult.getOrDefault(correct, 0L) * (long) PRIZE_MONEYS.get(correct);
                });
    }

    private long getNumOfCorrect(List<Integer> correctResult, int correct) {
        return (int) correctResult.stream()
                        .filter(num -> num == correct)
                        .count();
    }

    private static List<LottoNumber> purchaseLotto() {
        long purchaseAmount = inputPurchaseAmount();
        List<LottoNumber> purchasedLottoNumberList = new ArrayList<>();

        LongStream.range(0L, purchaseAmount)
                .forEach(i -> {
                    List<Integer> randomNumbers = createRandomNumbers();
                    LottoNumber newLottoNumber = new LottoNumber(randomNumbers);
                    purchasedLottoNumberList.add(newLottoNumber);
                });

        return purchasedLottoNumberList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.purchasedLottoNumberList.size()).append(PURCHASE_LOTTO_MESSAGE).append("\n");
        this.purchasedLottoNumberList.forEach(lotto -> sb.append(lotto).append("\n"));

        return sb.toString();
    }
}
