package lotto.domain;

public class WinningState {
    enum BonusState{
        TRUE,FALSE,NO_MATTER
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
    public boolean equals(Object winningState) {
        if (winningState instanceof WinningState){
            if (this.lottoCorrectCnt == ((WinningState) winningState).lottoCorrectCnt && (((WinningState) winningState).isBonus.equals(BonusState.NO_MATTER)) || this.isBonus==((WinningState) winningState).isBonus)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return lottoCorrectCnt;
    }
}
