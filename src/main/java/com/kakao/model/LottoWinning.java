package com.kakao.model;

import com.kakao.data.LottoData;
<<<<<<< HEAD
import com.kakao.exception.PickedNumberException;
import com.kakao.exception.PickedNumberRangeException;
=======
>>>>>>> 4f43f8b (1차 Commit)
import com.kakao.exception.PickedNumbersFormatException;

import java.util.List;

// 이번주 당첨정보
public class LottoWinning {
    private List<Integer> numberOfWinning;

<<<<<<< HEAD
    public LottoWinning(List<Integer> numberOfWinning) throws PickedNumberException {
        checkFormatOfPickedNumbers(numberOfWinning);
        checkRangeOfPickedNumbers(numberOfWinning);
        this.numberOfWinning = numberOfWinning;
    }

    // 유효성 검사
    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfWinning) throws PickedNumbersFormatException {
        if(pickedNumbersOfWinning == null || pickedNumbersOfWinning.size() != LottoData.NUMBER_OF_PICK) {
=======
    public LottoWinning(List<Integer> numberOfWinning) throws PickedNumbersFormatException {
        checkFormatOfPickedNumbers(numberOfWinning);
        this.numberOfWinning = numberOfWinning;
    }

    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        if(pickedNumbersOfLotto == null || pickedNumbersOfLotto.size() != LottoData.NUMBER_OF_PICK) {
>>>>>>> 4f43f8b (1차 Commit)
            // 데이터가 안들어오거나, 크기가 불일치하면 에러
            throw new PickedNumbersFormatException();
        }
    }
<<<<<<< HEAD
    private void checkRangeOfPickedNumbers(List<Integer> pickedNumbersOfWinning) throws PickedNumberRangeException {
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
=======
>>>>>>> 4f43f8b (1차 Commit)

    // 번호 보유 여부 확인
    public boolean hasNumber(int number) {
        return numberOfWinning.contains(number);
    }
}
