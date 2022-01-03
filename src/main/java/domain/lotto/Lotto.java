package domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> lottoNumbers;

    public Lotto(List<Number> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers;
    }

    public static Lotto makeOneRandomLotto() {
        List<Number> sixRandomNumber = RandomBucket.getSixRandomNumber();
        Collections.sort(sixRandomNumber);

        return new Lotto(sixRandomNumber);
    }
}
