package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumbersFormatException;

import java.util.List;

public class Lotto {
    // innerClass
    private List<Integer> pickedNumbersOfLotto;
    Lotto(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        checkFormatOfOPickedNumbers(pickedNumbersOfLotto);
        this.pickedNumbersOfLotto = pickedNumbersOfLotto;
    }

    private void checkFormatOfOPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        if(pickedNumbersOfLotto == null || pickedNumbersOfLotto.size() != LottoData.NUMBER_OF_PICK) {
            // 데이터가 안들어오거나, 크기가 불일치하면 에러
            throw new PickedNumbersFormatException();
        }
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