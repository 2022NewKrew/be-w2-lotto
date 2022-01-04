package model.lotto;

import model.number.Number;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LENGTH_OF_NUMBERS = 6;

    protected List<Number> numbers = null;

    protected Lotto() {}

    public long countDuplicateNumberWith(Lotto lotto) {
        return numbers
                .stream()
                .filter(number -> existIn(lotto, number))
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers
                .stream()
                .mapToInt(Number::convertToInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean existIn(Lotto lotto, Number number) {
        return lotto
                .getNumbers()
                .contains(Number.convertToInt(number));
    }
}
