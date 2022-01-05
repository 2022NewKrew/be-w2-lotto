package carrot.ez.lotto;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotteries {

    private final List<Lottery> lotteries = new ArrayList<>();

    public static Lotteries createLotteries(long numAutoLotteries, List<Lottery> manualLotteries) {
        Lotteries lotteries = new Lotteries();
        lotteries.generateLotteries(manualLotteries); // 수동 구매
        lotteries.autoGenerateLotteries(numAutoLotteries); // 자동 구매
        return lotteries;
    }

    private Lotteries() {
    }

    public Map<Rank, Long> checkWinningNumbers(List<Integer> winingNumbers, int bonus) {

        return lotteries.stream()
                .map(lottery -> Rank.of(lottery.getNumOfCorrect(winingNumbers), lottery.isCorrectBonus(bonus)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Lottery> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }

    public int getSize() {
        return lotteries.size();
    }

    public long getAutoSize() {
        return lotteries.stream()
                .filter(Lottery::isAuto)
                .count();
    }

    public long getManualSize() {
        return lotteries.stream()
                .filter(lottery -> !lottery.isAuto())
                .count();
    }

    private void autoGenerateLotteries(long numLotteries) {
        for (int i = 0; i < numLotteries; i++) {
            this.lotteries.add(LotteryGenerator.generateLotto());
        }
    }

    private void generateLotteries(List<Lottery> lotteries) {
        this.lotteries.addAll(lotteries);
    }
}
