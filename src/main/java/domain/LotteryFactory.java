package domain;

import property.LottoProperties;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryFactory {
    private static final Random random = new Random();

    public static List<Lottery> buildLotteries(long count) {
        return Stream.generate(LotteryFactory::buildSingleLottery)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static List<Lottery> buildLotteries(List<Set<Integer>> lotteryNumberSets) {
        return lotteryNumberSets.stream().map(LotteryFactory::buildSingleLottery)
                .collect(Collectors.toList());
    }

    private static Lottery buildSingleLottery() {
        return new Lottery(random.ints(LottoProperties.LOTTERY_NUMBER_START, LottoProperties.LOTTERY_NUMBER_END + 1)
                .distinct()
                .limit(LottoProperties.LOTTERY_NUMBER_COUNT)
                .boxed()
                .collect(Collectors.toSet()));
    }

    private static Lottery buildSingleLottery(Set<Integer> lotteryNumbers) {
        return new Lottery(lotteryNumbers);
    }
}
