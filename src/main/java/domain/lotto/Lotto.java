package domain.lotto;

import java.util.List;

public class Lotto {
    private final LottoNumber lottoNumber;

    public Lotto(List<Number> numbers) {
        lottoNumber = new LottoNumber(numbers);
    }

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public String lottoNumberToString() {
        return lottoNumber.numbersToString();
    }

    public static Lotto makeOneRandomLotto() {
        return new Lotto(LottoNumber.makeSixNumbersByRandom());
    }

    public int compareLotto(Lotto targetLotto) {
        return lottoNumber.compareLottoNumber(targetLotto.lottoNumber);
    }

    public int compareLottoWithBonus(Number bonusNumber) {
        return lottoNumber.compareBonusNumber(bonusNumber);
    }
}
