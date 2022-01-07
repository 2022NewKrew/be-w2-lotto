package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.PickedNumberException;
import com.kakao.exception.PickedNumberExistException;
import com.kakao.exception.PickedNumberFormatException;
import com.kakao.exception.PickedNumberRangeException;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers implements Serializable {
    List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) throws PickedNumberException {
        checkFormatOfPickedNumbers(lottoNumbers);
        checkRangeOfPickedNumbers(lottoNumbers);
        checkExistOfPickedNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
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
    private void checkExistOfPickedNumber(List<Integer> pickedNumbersOfWinning) throws PickedNumberExistException {
        // 중복 여부 확인
        Set<Integer> numberSet = pickedNumbersOfWinning.stream().collect(Collectors.toSet());
        if(numberSet.size() != LottoData.NUMBER_OF_PICK ) {
            throw new PickedNumberExistException();
        }
    }

    // getter
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean hasNumber(int number) {
        return lottoNumbers.contains(number);
    }

    private final String TO_STRING_OPENER = "[";
    private final String TO_STRING_CLOSER = "]";
    private final String TO_STRING_SEPARATOR = ",";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(TO_STRING_OPENER);
        for(Integer pickedNumber: lottoNumbers) {
            sb.append(pickedNumber);
            sb.append(TO_STRING_SEPARATOR);
        }
        sb.setLength(sb.length()-1); // 마지막 문자 삭제
        sb.append(TO_STRING_CLOSER);
        return sb.toString();
    }
}
