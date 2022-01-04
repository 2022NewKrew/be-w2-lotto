package lotto.service.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    protected List<Integer> numbers = new ArrayList<>();

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream().map(i->i.toString()).collect(Collectors.joining(",", "[", "]")).toString();
    }
}
