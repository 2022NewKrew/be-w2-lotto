package dto.input;

import java.util.Collections;
import java.util.List;

public class WinningNumbersDto {
    private final List<Integer> winningNumbers;
<<<<<<< HEAD
    private final Integer bonusNumber;

    public WinningNumbersDto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
=======

    public WinningNumbersDto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
<<<<<<< HEAD

    public int getBonusNumbers() {
        return this.bonusNumber;
    }
=======
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
}
