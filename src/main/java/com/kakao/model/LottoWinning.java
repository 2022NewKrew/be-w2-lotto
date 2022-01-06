package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumberException;
import com.kakao.exception.PickedNumberRangeException;
import com.kakao.exception.PickedNumberFormatException;

import java.util.List;

// 이번주 당첨정보
public class LottoWinning {
    private Integer bonusBall;
    private List<Integer> numberOfWinning;

    public LottoWinning(List<Integer> numberOfWinning) throws PickedNumberException {
        checkFormatOfPickedNumbers(numberOfWinning);
        checkRangeOfPickedNumbers(numberOfWinning);
        this.numberOfWinning = numberOfWinning;
    }

    // 유효성 검사
    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfWinning) throws PickedNumberFormatException {
        if(pickedNumbersOfWinning == null || pickedNumbersOfWinning.size() != LottoData.NUMBER_OF_PICK) {
            // 데이터가 안들어오거나, 크기가 불일치하면 에러
            throw new PickedNumberFormatException();
        }
    }

    private void checkRangeOfPickedNumbers(List<Integer> pickedNumbersOfWinning) throws PickedNumberRangeException {
        // 숫자 유효성 검사
        boolean allResult = pickedNumbersOfWinning.stream()
                .map(this::checkEachRangeOfPickedNumber)
                .reduce(true, this::checkAllNumbersAreExistInRange);
        if(!allResult) {
            throw new PickedNumberRangeException();
        }
    }
    private boolean checkEachRangeOfPickedNumber (Integer pickedNumber) {
        return ( LottoData.MIN_LOTTO_NUMBER <= pickedNumber ) && (pickedNumber <= LottoData.MAX_LOTTO_NUMBER);
    }
    private boolean checkAllNumbersAreExistInRange(boolean allResult, boolean isInRnage) {
        return allResult && isInRnage;
    }

    // BonusBall 세팅
    public void setBonusBall(Integer bonusBall) throws PickedNumberRangeException {
        if(bonusBall == null || !checkEachRangeOfPickedNumber(bonusBall)) {
            throw new PickedNumberRangeException();
        }
        this.bonusBall = bonusBall;
    }
    public Integer getBonusBall(){
        return this.bonusBall;
    }

    // 번호 보유 여부 확인
    public boolean hasNumber(int number) {
        return numberOfWinning.contains(number);
    }
}
