package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final List<Integer> digits;
    private final int bonusDigit;

    public WinningLotto(List<Integer> digits, int bonusDigit) {
        DomainValidationChecker checker = new DomainValidationChecker();
        checker.checkNumOfDigits(digits);
        checker.checkDigitsInWinningLotto(digits, bonusDigit);
        checker.checkDuplicationInWinningLotto(digits, bonusDigit);
        this.digits = digits;
        this.bonusDigit = bonusDigit;
    }

    public List<Integer> getDigits() {
        return Collections.unmodifiableList(digits);
    }

    public int getBonusDigit() {
        return bonusDigit;
    }
}
