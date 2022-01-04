package dto;

import java.util.List;

public class LastWeekWinningNumberDTO {
    private final List<Integer> lastWeekWinningNumber;
    private final int bonusNumber;

    public LastWeekWinningNumberDTO(List<Integer> lastWeekWinningNumber, int bonusNumber) {
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
