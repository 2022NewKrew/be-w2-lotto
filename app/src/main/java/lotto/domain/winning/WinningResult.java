package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.dto.WinningResultOutput;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class WinningResult {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningResultOutput winningResultRequest(List<Lotto> lotteries, int lottoPrice) {
        Map<String, Long> matchList = lotteries.stream()
                .map(lotto -> lotto.howManyLotteryNumbersAreIncluded(winningNumber, bonusNumber))
                .map(output -> WinningRanking.match(output.getMatchingCount(), output.getBonusNumberMatching()))
                .collect(groupingBy(WinningRanking::name, Collectors.counting()));

        int earningRate = EarningRate.calculate(matchList, lottoPrice);

        return new WinningResultOutput(matchList, earningRate);
    }
}
