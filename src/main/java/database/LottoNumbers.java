package database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers = new ArrayList<>();

    public LottoNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            this.numbers.add(lottoNumber);
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
