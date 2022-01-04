package lotto.domain;

import java.util.List;

/**
 * Created by melodist
 * Date: 2022-01-04 004
 * Time: 오후 5:52
 */
public class WinningLotto {
    private final List<Integer> lastWeekWinningNumbers;
    private final Integer bonusBall;

    public WinningLotto(List<Integer> lastWeekWinningNumbers, Integer bonusBall) {
        this.lastWeekWinningNumbers = lastWeekWinningNumbers;
        this.bonusBall = bonusBall;
    }

    public Rank matchLotto(Lotto lotto) {
        Integer winningNumberCount = lotto.matchLottoWithLastWeek(lastWeekWinningNumbers);
        boolean matchBonus = lotto.matchBonusBall(bonusBall);
        return Rank.valueOf(winningNumberCount, matchBonus);
    }
}
