package model.lotto;

import model.lotto.number.LottoNumber;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        LottoPrecondition.checkNumbers(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public int countDuplicateNumberWith(Lotto lotto) {
        return lotto
                .getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .toArray()
                .length;
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

}
