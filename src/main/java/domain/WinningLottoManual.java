package domain;

import java.util.List;

import static utils.Symbol.INVALID_DUPLICATION_BONUSNUM;

public class WinningLottoManual implements WinningLotto {
    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLottoManual(Lotto lotto, Number bonusNumber) {
        isDistinct(lotto,bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void isDistinct(Lotto winningLotto, Number bonusNumber) {
        List<Number> list = winningLotto.getNumberList();
        if(list.contains(bonusNumber)){
            throw new IllegalArgumentException(INVALID_DUPLICATION_BONUSNUM);
        }
    }

    @Override
    public Lotto getLotto() {
        return lotto;
    }

    @Override
    public Number getBonusNumber() {
        return bonusNumber;
    }
}
