package lotto.domain;

import java.util.List;

public abstract class Lotto {

    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNum(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    protected abstract void checkLottoNum(List<Integer> numbers);

    @Override
    public String toString() {
        return numbers.toString();
    }
}
