package lotto.domain.winningstats.lottobundle;

import lotto.domain.winningstats.lottobundle.lottoticket.Lotto;

public class LastWeekNumberBundle {

    private final Lotto lastWeekWinLotto;
    private final int bonusBall;

    public LastWeekNumberBundle(Lotto lastWeekWinLotto, int bonusBall) {
        this.lastWeekWinLotto = lastWeekWinLotto;
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public int addOneIfContains(int lottoNumber) {
        if (lastWeekWinLotto.contains(lottoNumber))
            return 1;
        return 0;
    }
}
