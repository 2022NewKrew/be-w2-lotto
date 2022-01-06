package lotto.domain.lotto;

import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.Lotto;
import lotto.domain.lotto.number.WinningNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries create(List<Lotto> lotteries) {
        return new Lotteries(lotteries);
    }

    public List<Lotto> forView() {
        return Collections.unmodifiableList(lotteries);
    }

    public List<MatchType> lotteriesMatch(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return lotteries.stream()
                .map(lotto -> lotto.howManyLotteryNumbersAreIncluded(winningNumber, bonusNumber))
                .map(output -> MatchType.match(output.getMatchingCount(), output.getBonusNumberMatching()))
                .collect(Collectors.toList());
    }
}
