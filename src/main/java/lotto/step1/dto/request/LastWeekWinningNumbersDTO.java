package lotto.step1.dto.request;

import java.util.List;

public class LastWeekWinningNumbersDTO {
    private final List<Integer> lastWeekWinningNumbers;

    public LastWeekWinningNumbersDTO(List<Integer> lastWeekWinningNumbers) {
        this.lastWeekWinningNumbers = lastWeekWinningNumbers;
    }

    public List<Integer> getLastWeekWinningNumbers() {
        return lastWeekWinningNumbers;
    }

}
