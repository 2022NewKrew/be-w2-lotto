package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Set<Integer> winningNumbers;

    public WinningLotto(List<Integer> numbers) {
        validate(numbers);
        this.winningNumbers = new HashSet<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        checkCountOfNumber(numbers.size());
        checkDuplicateNumbers(new HashSet<>(numbers).size());
    }

    private void checkCountOfNumber(int size) {
        if(size != Lotto.COUNT_OF_LOTTO_NUMBER){
            throw new IllegalArgumentException("로또 숫자의 개수가 올바르지 않습니다.");
        }
    }

    private void checkDuplicateNumbers(int size) {
        if(size != Lotto.COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("중복되는 숫자가 있습니다.");
        }
    }
}
