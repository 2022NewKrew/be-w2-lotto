package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.LottoRandomUtils;

public class Lotto {

    private static final int SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto() {
        this(LottoRandomUtils.getNumbers());
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersBound(numbers);
        validateNumbersRepeat(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개여야 합니다.");
        }
    }

    public void validateNumbersBound(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberBound(number);
        }
    }

    private void validateNumberBound(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 여야 합니다.");
        }
    }

    private void validateNumbersRepeat(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int matchCount(Lotto targetLotto) {
        Set<Integer> set = new HashSet<>(numbers);
        set.retainAll(targetLotto.numbers);
        return set.size();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
