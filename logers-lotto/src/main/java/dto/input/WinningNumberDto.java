package dto.input;

import java.util.Collections;
import java.util.List;

public class WinningNumberDto {
    private final List<Integer> winningNumbers;

    public WinningNumberDto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}
