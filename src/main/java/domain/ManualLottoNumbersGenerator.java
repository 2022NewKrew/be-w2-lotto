package domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersGenerator implements LottoNumbersGenerator {

    private final List<LottoNumber> numbers;

    public ManualLottoNumbersGenerator(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public LottoNumbers generate() {
        return new LottoNumbers(numbers);
    }
}
