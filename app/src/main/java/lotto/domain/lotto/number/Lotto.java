package lotto.domain.lotto.number;

import lotto.domain.dto.LottoMatchResultOutput;
import lotto.domain.lotto.strategy.LottoStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto extends Numbers {

    private Lotto(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static Lotto createLotto(LottoStrategy strategy) {
        return new Lotto(strategy.create());
    }

    public static Lotto createManualLotto(List<Integer> lotto) {
        return new Lotto(lotto.stream().sorted().collect(Collectors.toList()));
    }

    public LottoMatchResultOutput howManyLotteryNumbersAreIncluded(WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumber::isContainWinningNumber)
                .count();
        boolean bonusNumberMatching = numbers.stream()
                .anyMatch(bonusNumber::numberIsIncluded);
        return new LottoMatchResultOutput(bonusNumberMatching, matchCount);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
