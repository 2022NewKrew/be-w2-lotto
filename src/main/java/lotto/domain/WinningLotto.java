package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusDigit;

    public WinningLotto(List<Integer> digits, int bonusDigit) {
        super(digits);
        this.bonusDigit = bonusDigit;
    }

    public int getBonusDigit() {
        return bonusDigit;
    }
}
