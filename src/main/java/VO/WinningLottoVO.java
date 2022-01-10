package VO;

public class WinningLottoVO {
    String winningLottoString;
    int bonusNumber;

    public WinningLottoVO(String winningLottoString, int bonusNumber) {
        this.winningLottoString = winningLottoString;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningLottoString() {
        return winningLottoString;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
