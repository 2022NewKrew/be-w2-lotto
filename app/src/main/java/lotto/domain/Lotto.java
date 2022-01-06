package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Collections;
import java.util.Set;

/**
 * 로또 한 장의 정보와
 * 로또가 얼마나 맞았는지 확인하는 메소드가 있는 class
 */
public class Lotto {
    public static final int LOTTO_NUMBERS_COUNT = 6; // 로또 숫자 6개
    protected final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoNumberNotNull(lottoNumbers);
        checkLottoNumberCount(lottoNumbers);
        checkLottoNumberDuplicate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public final boolean contains(final LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    private void checkLottoNumberNotNull(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null)
            throw new IllegalArgumentException("Argument is expected not to be null.");
    }

    private void checkLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException("The size of lottoNumbers must be 6.");
    }

    private void checkLottoNumberDuplicate(List<LottoNumber> lottoNumbers) { // 중복 번호 있는지 확인
        Set<LottoNumber> tmpSet = new HashSet<>(lottoNumbers);
        if (tmpSet.size() != LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException("There are duplicated numbers in lottoNumbers.");
    }
}
