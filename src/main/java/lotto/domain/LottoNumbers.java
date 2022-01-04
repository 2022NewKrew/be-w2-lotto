package lotto.domain;

import java.util.Set;

public class LottoNumbers {
    static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers from(Set<LottoNumber> lottoNumbers) {
        if (!isValid(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 중복없는 6개의 숫자여야 합니다.");
        }
        return new LottoNumbers(lottoNumbers);
    }

    private static boolean isValid(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            return false;
        }
        return true;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumbers that = (LottoNumbers) o;

        return lottoNumbers.containsAll(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }
}
