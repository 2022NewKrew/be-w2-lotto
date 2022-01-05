package domain;

import property.LottoProperties;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryFactory {
    private static final Random random = new Random();

    public static List<Lottery> buildLotteries(long price) {
        return Stream.generate(LotteryFactory::buildSingleLottery)
                .limit(price / LottoProperties.LOTTERY_UNIT_PRICE)
                .collect(Collectors.toList());
    }

    private static Lottery buildSingleLottery() {
        return new Lottery(random.ints(LottoProperties.LOTTERY_NUMBER_START, LottoProperties.LOTTERY_NUMBER_END + 1)
                .distinct()
                .limit(LottoProperties.LOTTERY_NUMBER_COUNT)
                .boxed()
                .collect(Collectors.toSet()));
    }
}
