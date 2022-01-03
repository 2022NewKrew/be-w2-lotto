package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryFactory {
    private static final int LOTTERY_NUMBER_START = 1;
    private static final int LOTTERY_NUMBER_END = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private static final int LOTTERY_UNIT_PRICE = 1000;

    private static final Random random = new Random();

    public static List<Lottery> buildLotteries(long count) {
        return Stream.generate(LotteryFactory::buildSingleLottery)
                .limit(count / LOTTERY_UNIT_PRICE)
                .collect(Collectors.toList());
    }

    public static Lottery buildSingleLottery() {
        return new Lottery(random.ints(LOTTERY_NUMBER_START, LOTTERY_NUMBER_END + 1)
                .distinct()
                .limit(LOTTERY_NUMBER_COUNT)
                .sorted()
                .boxed()
                .collect(Collectors.toUnmodifiableList()));
    }
}
