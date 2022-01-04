package be.w2.lotto.lottos;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static int LENGTH = 6;

    protected List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean isContain(LottoNumber target) {
        return numbers.contains(target);
    }
}
