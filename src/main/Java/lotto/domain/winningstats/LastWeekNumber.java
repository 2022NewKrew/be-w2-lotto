package lotto.domain.winningstats;

import java.util.List;

public class LastWeekNumber {

    private final List<Integer> lastWeekLottoNumberList;
    private final int bonusBall;

    public LastWeekNumber(List<Integer> lastWeekLottoNumberList, int bonusBall) {
        this.lastWeekLottoNumberList = lastWeekLottoNumberList;
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public int addOneIfContains(int lottoNumber) {
        if (lastWeekLottoNumberList.contains(lottoNumber))
            return 1;
        return 0;
    }
}
