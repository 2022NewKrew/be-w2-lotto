package dto.input;

import domain.WinningNumber;

import java.util.List;

public class WinningNumberDto {
    private final List<Integer> winningNumbers;
    private final WinningNumber winningNumber;

    public WinningNumberDto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.winningNumber = new WinningNumber(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
