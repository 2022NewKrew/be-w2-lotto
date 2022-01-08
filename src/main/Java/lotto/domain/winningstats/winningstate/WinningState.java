package lotto.domain.winningstats.winningstate;

public class WinningState {
    enum BonusState {
        TRUE, FALSE, NO_MATTER
    }

    final int lottoCorrectCnt;
    final BonusState isBonus;

    public WinningState(int lottoCorrectCnt, boolean isBonus) {
        this.lottoCorrectCnt = lottoCorrectCnt;
        if (isBonus)
            this.isBonus = BonusState.TRUE;
        else
            this.isBonus = BonusState.FALSE;
    }

    public WinningState(int lottoCorrectCnt) {
        this.lottoCorrectCnt = lottoCorrectCnt;
        this.isBonus = BonusState.NO_MATTER;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WinningState) {
            WinningState winningState = (WinningState) o;
            return this.lottoCorrectCnt == winningState.lottoCorrectCnt
                    && ((winningState.isBonus.equals(BonusState.NO_MATTER)
                    || winningState.isBonus == this.isBonus));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return lottoCorrectCnt;
    }
}
