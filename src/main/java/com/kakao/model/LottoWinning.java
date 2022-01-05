package com.kakao.model;

import com.kakao.data.LottoData;
<<<<<<< HEAD
<<<<<<< HEAD
import com.kakao.exception.PickedNumberException;
import com.kakao.exception.PickedNumberRangeException;
=======
>>>>>>> 4f43f8b (1차 Commit)
=======
import com.kakao.exception.PickedNumberException;
import com.kakao.exception.PickedNumberRangeException;
>>>>>>> 2e87083 (- 로또 번호의 유효성 검사 추가)
import com.kakao.exception.PickedNumbersFormatException;

import java.util.List;

// 이번주 당첨정보
public class LottoWinning {
    private Integer bonusBall;
    private List<Integer> numberOfWinning;

<<<<<<< HEAD
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
=======
    public LottoWinning(List<Integer> numberOfWinning) throws PickedNumberException {
>>>>>>> 2e87083 (- 로또 번호의 유효성 검사 추가)
        checkFormatOfPickedNumbers(numberOfWinning);
        checkRangeOfPickedNumbers(numberOfWinning);
        this.numberOfWinning = numberOfWinning;
    }

<<<<<<< HEAD
    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        if(pickedNumbersOfLotto == null || pickedNumbersOfLotto.size() != LottoData.NUMBER_OF_PICK) {
>>>>>>> 4f43f8b (1차 Commit)
=======
    // 유효성 검사
    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfWinning) throws PickedNumbersFormatException {
        if(pickedNumbersOfWinning == null || pickedNumbersOfWinning.size() != LottoData.NUMBER_OF_PICK) {
>>>>>>> 2e87083 (- 로또 번호의 유효성 검사 추가)
            // 데이터가 안들어오거나, 크기가 불일치하면 에러
            throw new PickedNumbersFormatException();
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 2e87083 (- 로또 번호의 유효성 검사 추가)
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
<<<<<<< HEAD
=======
>>>>>>> 4f43f8b (1차 Commit)
=======
>>>>>>> 2e87083 (- 로또 번호의 유효성 검사 추가)

    // BonusBall 세팅
    public void setBonusBall(Integer bonusBall) throws PickedNumberRangeException {
        if(bonusBall == null || !checkEachRangeOfPickedNumber(bonusBall)) {
            throw new PickedNumberRangeException();
        }
        this.bonusBall = bonusBall;
    }

    // 번호 보유 여부 확인
    public boolean hasNumber(int number) {
        return numberOfWinning.contains(number);
    }
}
