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

<<<<<<< lotto-step3
    @Override
    public String toString() {
        return lottoNumber.toString();
=======
    public String lottoNumberToString() {
        return lottoNumber.numbersToString();
>>>>>>> devk0ng
    }

    public static Lotto makeOneRandomLotto() {
        return new Lotto(LottoNumber.makeSixNumbersByRandom());
    }

<<<<<<< lotto-step3
    public static Lotto makeOneInputLotto(List<Number> numbers) {
        return new Lotto(numbers);
    }

=======
>>>>>>> devk0ng
    public int compareLotto(Lotto targetLotto) {
        return lottoNumber.compareLottoNumber(targetLotto.lottoNumber);
    }

    public int compareLottoWithBonus(Number bonusNumber) {
        return lottoNumber.compareBonusNumber(bonusNumber);
    }
}
