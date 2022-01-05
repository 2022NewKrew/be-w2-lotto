package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumbersFormatException;

import java.util.List;

public class Lotto {
<<<<<<< HEAD
<<<<<<< HEAD

    private List<Integer> pickedNumbersOfLotto;

    Lotto(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        checkFormatOfPickedNumbers(pickedNumbersOfLotto);
        this.pickedNumbersOfLotto = pickedNumbersOfLotto;
    }

    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
=======
    // innerClass
=======

>>>>>>> 4f43f8b (1차 Commit)
    private List<Integer> pickedNumbersOfLotto;

    Lotto(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
        checkFormatOfPickedNumbers(pickedNumbersOfLotto);
        this.pickedNumbersOfLotto = pickedNumbersOfLotto;
    }

<<<<<<< HEAD
    private void checkFormatOfOPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
>>>>>>> edb2074 (1일차 중간 PR)
=======
    private void checkFormatOfPickedNumbers(List<Integer> pickedNumbersOfLotto) throws PickedNumbersFormatException {
>>>>>>> 4f43f8b (1차 Commit)
        if(pickedNumbersOfLotto == null || pickedNumbersOfLotto.size() != LottoData.NUMBER_OF_PICK) {
            // 데이터가 안들어오거나, 크기가 불일치하면 에러
            throw new PickedNumbersFormatException();
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4f43f8b (1차 Commit)
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

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> edb2074 (1일차 중간 PR)
=======
>>>>>>> 4f43f8b (1차 Commit)
=======
    // 보너스볼 여부 확인
    public boolean matchBonusBall(Integer bonusBall) {
        return pickedNumbersOfLotto.contains(bonusBall);
    }

>>>>>>> d64e878 (- bonusBall 관련 로직 추가처리 (출력 분기 / getter,setter))
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