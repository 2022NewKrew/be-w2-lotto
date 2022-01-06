package lotto.domain.lotto.number;

import lotto.domain.dto.LottoMatchResultOutput;

import java.util.List;

public class Lotto extends Numbers {

    private Lotto(List<Integer> lottoNumber) {
        super(lottoNumber);
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public LottoMatchResultOutput howManyLotteryNumbersAreIncluded(WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = howManyNumberIncluded(winningNumber);
        boolean bonusNumberMatching = isContainNumbers(bonusNumber);
        return new LottoMatchResultOutput(bonusNumberMatching, matchCount);
    }
}
