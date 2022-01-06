package lotto.domain.lotto.result;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.WinningNumber;
import lotto.dto.WinningResultOutput;

import java.util.EnumMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class WinningResult {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningResultOutput winningResultRequest(Lotteries lotteries, int lottoPrice) {
        Map<WinningRanking, Long> matchRank = lotteries.lotteriesMatch(winningNumber, bonusNumber).stream()
                .map(WinningRanking::match)
                .collect(groupingBy(value -> value, () -> new EnumMap<>(WinningRanking.class), counting()));
        int earningRate = EarningRate.calculate(matchRank, lottoPrice);

        return new WinningResultOutput(matchRank, earningRate);
    }
}
