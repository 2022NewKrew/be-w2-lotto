package dto.input;

import java.util.Collections;
import java.util.List;

public class WinningNumbersDto {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumbersDto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumbers() {
        return this.bonusNumber;
    }
}
