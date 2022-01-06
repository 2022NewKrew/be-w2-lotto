package domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import utility.LotteryGenerator;

public class Lotteries {

    private static final String VALIDATE_PRICE_MESSAGE = "구입금액을 초과하여 구매할 수 없습니다.";
    private static final String VALIDATE_MANUAL_LOTTERIES_MESSAGE = "요청하신 수동 로또 갯수와 입력하신 수동 로또 번호 갯수가 불일치합니다.";
    private static final int PRICE = 1_000;

    private final List<Lottery> autoLotteries;
    private final List<Lottery> manualLotteries;

    public Lotteries(int totalLotteriesPrice, int manualLotteriesAmount, List<List<Integer>> manualNumbers) {
        validate(totalLotteriesPrice, manualLotteriesAmount, manualNumbers);
        autoLotteries = LotteryGenerator.randomLotteriesGenerator(totalLotteriesPrice / PRICE - manualLotteriesAmount);
        manualLotteries = LotteryGenerator.manualLotteriesGenerator(manualNumbers);
    }

    private void validate(int totalLotteriesPrice, int manualLotteriesAmount, List<List<Integer>> manualNumbers) {
        validatePrice(totalLotteriesPrice, manualLotteriesAmount);
        validateManualLotteries(manualLotteriesAmount, manualNumbers);
    }

    private void validatePrice(int totalLotteriesPrice, int manualLotteriesAmount) {
        if (totalLotteriesPrice / PRICE < manualLotteriesAmount) {
            throw new IllegalArgumentException(VALIDATE_PRICE_MESSAGE);
        }
    }

    private void validateManualLotteries(int manualLotteriesAmount, List<List<Integer>> manualNumbers) {
        if (manualLotteriesAmount != manualNumbers.size()) {
            throw new IllegalArgumentException(VALIDATE_MANUAL_LOTTERIES_MESSAGE);
        }
    }

    public Result compareLotteries(WinningLottery winningLottery) {
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);

        Arrays.asList(Rank.values()).stream().forEach(rank -> results.put(rank, 0));
        Stream.concat(autoLotteries.stream(), manualLotteries.stream())
                .forEach(lottery -> {
                    Rank rank = lottery.compareNumbers(winningLottery);
                    results.put(rank, results.get(rank) + 1);
                });
        return new Result(results);
    }

    public List<Lottery> getAutoLotteries() {
        return this.autoLotteries;
    }

    public List<Lottery> getManualLotteries() {
        return this.manualLotteries;
    }

    public int getPrice() {
        return PRICE;
    }
}
