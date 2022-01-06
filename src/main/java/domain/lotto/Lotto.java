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

    @Override
    public String toString() {
        return lottoNumber.toString();
    }

    public static Lotto makeOneRandomLotto() {
        return new Lotto(LottoNumber.makeSixNumbersByRandom());
    }

    public static Lotto makeOneInputLotto(List<Number> numbers) {
        return new Lotto(numbers);
    }

    public int compareLotto(Lotto targetLotto) {
        return lottoNumber.compareLottoNumber(targetLotto.lottoNumber);
    }

    public int compareLottoWithBonus(Number bonusNumber) {
        return lottoNumber.compareBonusNumber(bonusNumber);
    }
}
