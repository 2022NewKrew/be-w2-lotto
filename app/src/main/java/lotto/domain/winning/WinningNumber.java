package lotto.domain.winning;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumber() {
        return new ArrayList<>(winningNumbers);
    }
}
