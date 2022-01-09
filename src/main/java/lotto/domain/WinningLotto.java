package lotto.domain;

import lotto.constant.Rank;

import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningNumbers;

    public WinningLotto(List<Integer> numbers) {
        this.winningNumbers = new Lotto(numbers).getSetNumbers();
    }

    public Rank getWinningLottoRank(Lotto lotto) {
        return Rank.valueOf(matchCountOfWinningNumbers(lotto));
    }

    public int matchCountOfWinningNumbers(Lotto lotto) {
        Set<Integer> setNumbers = lotto.getSetNumbers();
        setNumbers.retainAll(winningNumbers);
        return setNumbers.size();
    }
}
