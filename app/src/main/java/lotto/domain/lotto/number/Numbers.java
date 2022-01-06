package lotto.domain.lotto.number;

import java.util.List;

import static java.util.stream.Collectors.*;

public abstract class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        validNumbersLength(numbers);
        this.numbers = numbers.stream().map(Number::new).collect(toList());
    }

    public int howManyNumberIncluded(Numbers comparedNumbers) {
        return (int) numbers.stream()
                .filter(comparedNumbers::isContainNumbers)
                .count();
    }

    public boolean isContainNumbers(Number number) {
        return numbers.contains(number);
    }

    private void validNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("길이가 6이 되어야 합니다");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
