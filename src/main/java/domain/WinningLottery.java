package domain;

import java.util.List;

public class WinningLottery {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLottery(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
