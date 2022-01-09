package domain;

import exception.DuplicatedLottoNumberException;
import exception.InvalidLottoLengthException;
import exception.InvalidLottoNumberException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private final Set<Integer> lotto;
    private final Integer MINIMUM_LOTTO_NUMBER = 1;
    private final Integer MAXIMUM_LOTTO_NUMBER = 45;

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
                .anyMatch(i -> i > MAXIMUM_LOTTO_NUMBER || i < MINIMUM_LOTTO_NUMBER);

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
