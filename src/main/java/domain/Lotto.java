package domain;

import exception.DuplicatedLottoNumberException;
import exception.InvalidLottoLengthException;
import exception.InvalidLottoNumberException;

import java.util.*;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateDuplicateNumber(lotto);
        validateInvalidNumber(lotto);
        validateInvalidLength(lotto);
        validateNull(lotto);
        this.lotto = Collections.unmodifiableList(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public boolean contains(Integer bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    private void validateDuplicateNumber(List<Integer> lotto) {
        Set<Integer> unDuplicateLotto = new HashSet<>(lotto);
        if (unDuplicateLotto.size() != lotto.size()) {
            throw new DuplicatedLottoNumberException(DuplicatedLottoNumberException.DUPLICATE_NUMBER);
        }
    }

    private void validateInvalidNumber(List<Integer> lotto) {
        boolean invalidRangeNumber = lotto.stream()
                .anyMatch(i -> i > 45 || i < 0);

        if (invalidRangeNumber) {
            throw new InvalidLottoNumberException(InvalidLottoNumberException.INVALID_RANGE_NUMBER);
        }
    }

    private void validateInvalidLength(List<Integer> lotto) {
        if (lotto.size() != InvalidLottoLengthException.LOTTO_LENGTH) {
            throw new InvalidLottoLengthException(InvalidLottoLengthException.INVALID_LENGTH);
        }
    }

    private void validateNull(List<Integer> lotto) {
        if (lotto == null) {
            throw new IllegalArgumentException();
        }
    }
}
