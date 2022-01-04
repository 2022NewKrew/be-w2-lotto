package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumbersFormatException;

import java.util.List;

// 이번주 당첨정보
public class LottoWinning {
    private List<Integer> numberOfWinning;

    public LottoWinning(List<Integer> numberOfWinning) throws PickedNumbersFormatException {
        checkFormatOfPickedNumbers(numberOfWinning);
        this.numberOfWinning = numberOfWinning;
    }

    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        if(pickedNumbersOfLotto == null || pickedNumbersOfLotto.size() != LottoData.NUMBER_OF_PICK) {
            // 데이터가 안들어오거나, 크기가 불일치하면 에러
            throw new PickedNumbersFormatException();
        }
    }

    // 번호 보유 여부 확인
    public boolean hasNumber(int number) {
        return numberOfWinning.contains(number);
    }
}
