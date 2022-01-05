package domain;

import exception.DuplicatedLottoNumberException;
import exception.InvalidLottoNumberException;

import java.util.*;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateDuplicateNumber(lotto);
        validateInvalidNumber(lotto);
        this.lotto = Collections.unmodifiableList(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Integer getLottoSize() {
        return lotto.size();
    }

    private void validateDuplicateNumber(List<Integer> lotto) {
        Set<Integer> unDuplicateLotto = new HashSet<>(lotto);
        if (unDuplicateLotto.size() != lotto.size()) {
            throw new DuplicatedLottoNumberException(DuplicatedLottoNumberException.DUPLICATE_NUMBER);
        }
    }

    private void validateInvalidNumber(List<Integer> lotto) {
        Optional<Integer> invalidRangeNumber = lotto.stream()
                .filter(i -> i > 45 || i < 0)
                .findAny();
        if (invalidRangeNumber.isEmpty()) {
            throw new InvalidLottoNumberException(InvalidLottoNumberException.INVALID_RANGE_NUMBER);
        }


    }
}
