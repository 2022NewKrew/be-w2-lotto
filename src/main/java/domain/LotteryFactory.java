package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryFactory {
    private static final Random random = new Random();

    public static List<Lottery> buildLotteries(long price, Rule rule) {
        return Stream.generate(() -> buildSingleLottery(rule))
                .limit(price / rule.getLotteryUnitPrice())
                .collect(Collectors.toList());
    }

    public static Lottery buildSingleLottery(Rule rule) {
        return new Lottery(random.ints(rule.getLotteryNumberStart(), rule.getLotteryNumberEnd() + 1)
                .distinct()
                .limit(rule.getLotteryNumberCount())
                .sorted()
                .boxed()
                .collect(Collectors.toUnmodifiableList()));
    }
}
