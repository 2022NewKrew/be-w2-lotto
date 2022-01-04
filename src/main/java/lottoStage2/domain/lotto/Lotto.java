package lottoStage2.domain.lotto;

import lottoStage2.domain.vo.Number;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

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
