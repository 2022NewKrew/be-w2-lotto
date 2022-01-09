package model.lotto;

import model.lotto.number.LottoNumber;
import model.lotto.strategy.GenerateLottoStrategy;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(GenerateLottoStrategy generateLottoStrategy) {
        this.lottoNumbers = generateLottoStrategy.generate();
    }

    public int contain(Lotto lotto) {
        return (int) lotto
                .getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public boolean contain(LottoNumber targetLottoNumber) {
        return lottoNumbers.contains(targetLottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
