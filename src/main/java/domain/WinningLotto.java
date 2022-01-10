package domain;

import java.util.List;

public class WinningLotto implements Lotto{
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return String.format("numbers: %s, bonusNumber: %d", String.join(", ", numbers.toString()), bonusNumber);
    }
}
