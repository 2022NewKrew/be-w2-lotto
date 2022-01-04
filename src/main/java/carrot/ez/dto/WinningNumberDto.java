package carrot.ez.dto;

import java.util.List;

public class WinningNumberDto {
    List<Integer> winningNumber;
    int bonus;

    public WinningNumberDto(List<Integer> winningNumbers, int bonus) {
        this.winningNumber = winningNumbers;
        this.bonus = bonus;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonus() {
        return bonus;
    }
}
