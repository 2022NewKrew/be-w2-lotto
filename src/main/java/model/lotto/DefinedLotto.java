package model.lotto;

import model.number.Number;

import java.util.List;
import java.util.stream.Collectors;

public class DefinedLotto extends Lotto {

    public DefinedLotto(List<Integer> numbers) {
        super.numbers = numbers.stream().map(Number::new).collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers
                .stream()
                .mapToInt(Number::convertToInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
