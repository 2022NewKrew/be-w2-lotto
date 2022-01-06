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
        checkLottoNumberNotNull();
        checkLottoNumberCount();
        checkLottoNumberDuplicate();
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

    private void checkLottoNumberNotNull() {
        if (lottoNumbers == null)
            throw new IllegalArgumentException();
    }

    private void checkLottoNumberCount() {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException();
    }

    private void checkLottoNumberDuplicate() { // 중복 번호 있는지 확인
        Set<LottoNumber> tmpSet = new HashSet<>(lottoNumbers);
        if (tmpSet.size() != LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException();
    }
}
