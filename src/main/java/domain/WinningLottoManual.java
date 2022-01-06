package domain;

public class WinningLottoManual implements WinningLotto {
    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLottoManual(Lotto lotto, Number bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
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
