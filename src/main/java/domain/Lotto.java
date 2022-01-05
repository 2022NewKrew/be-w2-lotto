package domain;

import exception.DuplicatedLottoNumberException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateDuplicateNumbers(lotto);
        this.lotto = Collections.unmodifiableList(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Integer getLottoSize() {
        return lotto.size();
    }

    private void validateDuplicateNumbers(List<Integer> lotto) {
        Set<Integer> unDuplicateLotto = new HashSet<>(lotto);
        if (unDuplicateLotto.size() != lotto.size()) {
            throw new DuplicatedLottoNumberException(DuplicatedLottoNumberException.DUPLICATE_NUMBER);
        }
    }
}
