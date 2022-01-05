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
    private static final int LOTTO_NUMBERS_COUNT = 6; // 로또 숫자 6개
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoNumberCount(lottoNumbers);
        checkLottoNumberDuplicate(lottoNumbers);

        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public final int match(final List<LottoNumber> winningNumbers, final LottoNumber bonusBall) {
        int count = 0;
        for(LottoNumber number : winningNumbers)
            count += lottoNumbers.contains(number) ? 1 : 0;

        // 보너스볼 포함해서 다 맞은 경우(2등)와 구별하기 위해
        // 보너스볼 제외하고 다 맞은 경우 7개 맞춘 것으로 반환 (1등)
        if(count == LOTTO_NUMBERS_COUNT)
            return LOTTO_NUMBERS_COUNT + 1; // 7

        if(lottoNumbers.contains(bonusBall))
            count += 1;
        return count;
    }

    private static void checkLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException();
    }

    private static void checkLottoNumberDuplicate(List<LottoNumber> lottoNumbers) { // 중복 번호 있는지 확인
        Set<LottoNumber> tmpSet = new HashSet<>(lottoNumbers);
        if(tmpSet.size() != LOTTO_NUMBERS_COUNT)
            throw new IllegalArgumentException();
    }
}
