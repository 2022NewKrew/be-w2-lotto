package business.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryMachine {

    public static LotteryTicket issueRandomLotteryTicket(LotteryCount lotteryCount) {
        return new LotteryTicket(
            Stream.generate(LotteryNumbers::random).limit(lotteryCount.getValue())
                .collect(Collectors.toList()));
    }

    public static LotteryTicket issueManualLotteryTicket(List<Set<Integer>> integerSetList) {
        return new LotteryTicket(
            integerSetList.stream().map(LotteryNumbers::from).collect(Collectors.toList()));
    }
}
