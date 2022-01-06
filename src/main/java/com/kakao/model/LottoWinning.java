package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumberExistException;
import com.kakao.exception.PickedNumberRangeException;

// 이번주 당첨정보
public class LottoWinning {
    private Integer bonusBall;
    private LottoNumbers numberOfWinning;

    public LottoWinning(LottoNumbers numberOfWinning) {
        this.numberOfWinning = numberOfWinning;
    }

    // 유효성 검사
    private boolean checkBonusBallRangeOfPickedNumber (Integer pickedNumber) {
        return ( LottoData.MIN_LOTTO_NUMBER <= pickedNumber ) && (pickedNumber <= LottoData.MAX_LOTTO_NUMBER);
    }

    // BonusBall 세팅
    public void setBonusBall(Integer bonusBall) throws PickedNumberRangeException, PickedNumberExistException {
        if(bonusBall == null || !checkBonusBallRangeOfPickedNumber(bonusBall)) {
            throw new PickedNumberRangeException();
        }
        if(numberOfWinning.hasNumber(bonusBall)) {
            throw new PickedNumberExistException();
        }
        this.bonusBall = bonusBall;
    }
    public Integer getBonusBall(){
        return this.bonusBall;
    }

    // 번호 보유 여부 확인
    public boolean hasNumber(int number) {
        return numberOfWinning.hasNumber(number);
    }
}
