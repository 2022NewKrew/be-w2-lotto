package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers.getLottoNumbers());
    }
}
