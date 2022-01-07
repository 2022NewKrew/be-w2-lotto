package VO;

public class WinningLottoVO {
    String winningLotto;
    int bonusNumber;

    public WinningLottoVO(String winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
