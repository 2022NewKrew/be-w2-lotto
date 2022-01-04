package lotto.domain.lotto;

import lotto.domain.dto.LottoMatchResultOutput;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningNumber;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumber;

    private Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static Lotto createLotto(LottoStrategy strategy) {
        return new Lotto(strategy.create());
    }

    public LottoMatchResultOutput howManyLotteryNumbersAreIncluded(WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = (int) lottoNumber.stream()
                .filter(winningNumber::isContainWinningNumber)
                .count();
        boolean bonusNumberMatching = lottoNumber.stream()
                .anyMatch(bonusNumber::bonusNumberIsIncluded);
        return new LottoMatchResultOutput(bonusNumberMatching, matchCount);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
