package lotto.domain;

import java.util.List;

public class LottoWinningNumber extends Lotto {
    private final LottoNumber bonusBall;

    public LottoWinningNumber(List<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        super(lottoNumbers);
        checkBonusBallDuplicate(bonusBall);
        this.bonusBall = bonusBall;
    }

    public final int match(Lotto lotto) {
        int count = 0;
        for(LottoNumber number : lottoNumbers)
            count += lotto.contains(number) ? 1 : 0;

        // 보너스볼 포함해서 다 맞은 경우(2등)와 구별하기 위해
        // 보너스볼 제외하고 다 맞은 경우 7개 맞춘 것으로 반환 (1등)
        if(count == LOTTO_NUMBERS_COUNT)
            return LOTTO_NUMBERS_COUNT + 1; // 7

        if(lotto.contains(bonusBall))
            count += 1;
        return count;
    }

    private void checkBonusBallDuplicate(LottoNumber bonusBall) {
        if(super.lottoNumbers.contains(bonusBall))
            throw new IllegalArgumentException();
    }
}
