package model.lotto.strategy;

import model.lotto.number.LottoNumber;
import utility.NullChecker;

import java.util.List;
import java.util.stream.Collectors;

public class DefinedGenerateStrategy implements GenerateLottoStrategy {

    List<LottoNumber> numbers;

    public DefinedGenerateStrategy(List<Integer> numbers) {
        NullChecker.checkNotNull(numbers);

        this.numbers = integersToNumbers(numbers);
    }

    @Override
    public List<LottoNumber> generate() {
        return numbers;
    }

    private List<LottoNumber> integersToNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::valueOf).collect(Collectors.toUnmodifiableList());
    }
}
