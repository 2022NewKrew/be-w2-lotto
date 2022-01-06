package lotto.step1.dto.request;

import java.util.List;

public class ConfirmTheWinDTO {
    private final List<Integer> lastWeekWinningNumbers;

    public ConfirmTheWinDTO(List<Integer> lastWeekWinningNumbers) {
        this.lastWeekWinningNumbers = lastWeekWinningNumbers;
    }

    public List<Integer> getLastWeekWinningNumbers() {
        return lastWeekWinningNumbers;
    }

}
