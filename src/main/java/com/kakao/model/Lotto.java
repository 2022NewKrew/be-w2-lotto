package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumbersFormatException;

import java.util.List;

public class Lotto {

    private List<Integer> pickedNumbersOfLotto;

    Lotto(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        checkFormatOfPickedNumbers(pickedNumbersOfLotto);
        this.pickedNumbersOfLotto = pickedNumbersOfLotto;
    }

    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        if(pickedNumbersOfLotto == null || pickedNumbersOfLotto.size() != LottoData.NUMBER_OF_PICK) {
            // 데이터가 안들어오거나, 크기가 불일치하면 에러
            throw new PickedNumbersFormatException();
        }
    }

    // 당첨여부 확인
    public int matchNumberIsWinning(LottoWinning lottoWinning) {
        // 당첨번호, 매치여부를 확인할 숫자
        int matchCount = 0;
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