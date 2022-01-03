package lottoStage1.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers lottoNumbers;

    private Lotto() {
        lottoNumbers = LottoNumbers.create();
    }

    private Lotto(String[] numbers) {
        lottoNumbers = LottoNumbers.of(numbers);
    }

    public static Lotto generate() {
        return new Lotto();
    }

    public static Lotto of(String[] numbers) {
        return new Lotto(numbers);
    }

    public int match(Lotto lotto) {
        return lottoNumbers.match(lotto.getLottoNumbers());
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }
}
