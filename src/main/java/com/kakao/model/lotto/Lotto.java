package com.kakao.model.lotto;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumberException;
import com.kakao.exception.PickedNumberRangeException;
import com.kakao.exception.PickedNumberFormatException;
import com.kakao.model.LottoNumbers;
import com.kakao.model.LottoWinning;

import java.util.List;

public abstract class Lotto {
    private LottoNumbers pickedNumbersOfLotto;

    Lotto(List<Integer> pickedNumbersOfLotto) throws PickedNumberException {
        this.pickedNumbersOfLotto = new LottoNumbers(pickedNumbersOfLotto);
    }
    Lotto(LottoNumbers pickedNumbersOfLotto) {
        this.pickedNumbersOfLotto = pickedNumbersOfLotto;
    }

    // 당첨여부 확인
    public int matchNumberIsWinning(LottoWinning lottoWinning) {
        // 당첨번호, 매치여부를 확인할 숫자
        int matchCount = 0;
        if( lottoWinning == null ) {
            return matchCount;
        }

        for(Integer lottoNumber: pickedNumbersOfLotto.getLottoNumbers()){
            matchCount = updateWinningNumber(matchCount, lottoWinning.hasNumber(lottoNumber));
        }
        return matchCount;
    }
    private int updateWinningNumber(int matchCount, boolean hasNumber) {
        if (hasNumber) {
            matchCount += 1;
        }
        return matchCount;
    }

    // 보너스볼 여부 확인
    public boolean matchBonusBall(Integer bonusBall) {
        return bonusBall != null && pickedNumbersOfLotto.hasNumber(bonusBall);
    }

    @Override
    public String toString() {
        return pickedNumbersOfLotto.toString();
    }
}