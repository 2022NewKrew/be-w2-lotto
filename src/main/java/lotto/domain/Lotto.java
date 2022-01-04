package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> digits;

    public Lotto(List<Integer> digits) {
        this.digits = digits;
    }

    public List<Integer> getDigits() {
        return Collections.unmodifiableList(digits);
    }

    public int getNumOfMatchingDigits(WinningLotto winningLotto) {
        return (int) digits.stream()
                .filter(digit -> winningLotto.getDigits().contains(digit))
                .count();
    }

    public boolean isContainBonus(WinningLotto winningLotto) {
        return digits.contains(winningLotto.getBonusDigit());
    }
}
