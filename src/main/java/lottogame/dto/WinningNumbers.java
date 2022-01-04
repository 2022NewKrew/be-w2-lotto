package lottogame.dto;

import java.util.List;

public class WinningNumbers {
    List<Integer> numbers;

    public WinningNumbers() {
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
