package model.lotto;

import model.lotto.number.LottoNumber;
import utility.NullChecker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LENGTH_OF_NUMBERS = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkNumbers(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
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

    private void checkNumbers(List<LottoNumber> lottoNumbers) {
        checkNull(lottoNumbers);
        checkNumbersLength(lottoNumbers);
        checkDuplicateNumber(lottoNumbers);
    }

    private void checkNull(List<LottoNumber> lottoNumbers) {
        NullChecker.checkNotNull(lottoNumbers);
    }

    private void checkNumbersLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.LENGTH_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 부적절합니다!");
        }
    }

    private void checkDuplicateNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> testSet = new HashSet<>(lottoNumbers);
        if (testSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }
}
