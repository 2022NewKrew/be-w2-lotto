package domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto implements Lotto{
    private List<Integer> numbers;
    private int bonusNumber;

    WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public String toString() {
        return String.format("numbers: %s, bonusNumber: %d", String.join(", ", numbers.toString()), bonusNumber);
    }
}
