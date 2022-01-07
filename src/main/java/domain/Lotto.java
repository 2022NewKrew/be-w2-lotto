package domain;

import exception.DuplicatedLottoNumberException;
import exception.InvalidLottoLengthException;
import exception.InvalidLottoNumberException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        validateDuplicateNumber(lotto);
        validateInvalidNumber(lotto);
        validateInvalidLength(lotto);
        validateNull(lotto);
        this.lotto = Collections.unmodifiableSet(lotto);
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    public boolean contains(Integer bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private void validateDuplicateNumber(Set<Integer> lotto) {
        Set<Integer> unDuplicateLotto = new HashSet<>(lotto);
        if (unDuplicateLotto.size() != lotto.size()) {
            throw new DuplicatedLottoNumberException(DuplicatedLottoNumberException.DUPLICATE_NUMBER);
        }
    }

    private void validateInvalidNumber(Set<Integer> lotto) {
        boolean invalidRangeNumber = lotto.stream()
                .anyMatch(i -> i > 45 || i < 1);

        if (invalidRangeNumber) {
            throw new InvalidLottoNumberException(InvalidLottoNumberException.INVALID_RANGE_NUMBER);
        }
    }

    private void validateInvalidLength(Set<Integer> lotto) {
        if (lotto.size() != InvalidLottoLengthException.LOTTO_LENGTH) {
            throw new InvalidLottoLengthException(InvalidLottoLengthException.INVALID_LENGTH);
        }
    }

    private void validateNull(Set<Integer> lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }
    }
}
