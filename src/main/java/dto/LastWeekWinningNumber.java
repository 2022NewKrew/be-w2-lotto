package dto;

import java.util.List;

public class LastWeekWinningNumber {
    private final List<Integer> lastWeekWinningNumber;
    private final int bonusNumber;

    public LastWeekWinningNumber(List<Integer> lastWeekWinningNumber, int bonusNumber) {
        this.lastWeekWinningNumber = lastWeekWinningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLastWeekWinningNumber() {
        return lastWeekWinningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
