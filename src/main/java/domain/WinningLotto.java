package domain;

import java.util.ArrayList;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(ArrayList<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
