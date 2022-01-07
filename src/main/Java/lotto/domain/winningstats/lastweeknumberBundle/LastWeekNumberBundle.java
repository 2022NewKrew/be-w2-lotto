package lotto.domain.winningstats.lastweeknumberBundle;

import java.util.List;

public class LastWeekNumberBundle {

    private final LastWeekLottoNumberList lastWeekLottoNumberList;
    private final int bonusBall;

    public LastWeekNumberBundle(LastWeekLottoNumberList lastWeekLottoNumberList, int bonusBall) {
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
