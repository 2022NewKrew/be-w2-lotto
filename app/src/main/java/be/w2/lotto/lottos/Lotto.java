package be.w2.lotto.lottos;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static int LENGTH = 6;

    protected List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<String> getListOfStringForLottoNumbers() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isContain(LottoNumber target) {
        return numbers.contains(target);
    }
}
