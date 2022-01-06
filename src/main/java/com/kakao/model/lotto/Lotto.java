package com.kakao.model.lotto;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumberException;
import com.kakao.exception.PickedNumberRangeException;
import com.kakao.exception.PickedNumberFormatException;
import com.kakao.model.LottoWinning;

import java.util.List;

public abstract class Lotto {
    private List<Integer> pickedNumbersOfLotto;

    Lotto(List<Integer> pickedNumbersOfLotto) throws PickedNumberException {
        checkFormatOfPickedNumbers(pickedNumbersOfLotto);
        checkRangeOfPickedNumbers(pickedNumbersOfLotto);
        this.pickedNumbersOfLotto = pickedNumbersOfLotto;
    }

    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumberFormatException {
        if(pickedNumbersOfLotto == null || pickedNumbersOfLotto.size() != LottoData.NUMBER_OF_PICK) {
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

    // 당첨여부 확인
    public int matchNumberIsWinning(LottoWinning lottoWinning) {
        // 당첨번호, 매치여부를 확인할 숫자
        int matchCount = 0;
        if( lottoWinning == null ) {
            return matchCount;
        }

        for(Integer lottoNumber: pickedNumbersOfLotto){
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
        return bonusBall != null && pickedNumbersOfLotto.contains(bonusBall);
    }

    private final String TO_STRING_OPENER = "[";
    private final String TO_STRING_CLOSER = "]";
    private final String TO_STRING_SEPARATOR = ",";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(TO_STRING_OPENER);
        for(Integer pickedNumber: pickedNumbersOfLotto) {
            sb.append(pickedNumber);
            sb.append(TO_STRING_SEPARATOR);
        }
        sb.setLength(sb.length()-1); // 마지막 문자 삭제
        sb.append(TO_STRING_CLOSER);
        return sb.toString();
    }
}