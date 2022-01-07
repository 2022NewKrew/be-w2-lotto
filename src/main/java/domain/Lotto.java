package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(LottoNumbersGenerator generator) {
        this.numbers = generator.generate();
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers.getLottoNumbers());
    }
}
