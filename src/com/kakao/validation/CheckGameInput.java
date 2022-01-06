package com.kakao.validation;

import java.util.*;

public class CheckGameInput {

    private static final int LOTTO_NUMBER_COUNT = 6;

    public void checkNegativeNumber(int input) {
        if (input < 0) {
            throw new RuntimeException(ExceptionMessage.MONEY.getMessage());
        }
    }

    public void checkNumberValidation(int num) {
        if (num < 1 || num > 45) {
            throw new RuntimeException(ExceptionMessage.NUMBER_VALIDATION.getMessage());
        }
    }

    public void checkLottoInput(List<Integer> input) {
        checkNumberCount(input);
        checkNumberOverlap(input);
    }

    private void checkNumberCount(List<Integer> input) {
        if (input.size() != LOTTO_NUMBER_COUNT) {
            throw new RuntimeException(ExceptionMessage.NUMBER_COUNT.getMessage());
        }
    }

    private void checkNumberOverlap(List<Integer> lotto) {
        Set<Integer> lottoSet = new HashSet<>(lotto);
        if (lottoSet.size() != LOTTO_NUMBER_COUNT) {
            throw new RuntimeException(ExceptionMessage.NUMBER_OVERLAP.getMessage());
        }
    }

    public void checkLottoCount(int totalLottoCount, int lottoCount) {
        checkNegativeNumber(lottoCount);
        if (totalLottoCount < lottoCount) {
            String message = "(최대 " + totalLottoCount + "개 구매가능)";
            throw new RuntimeException(ExceptionMessage.COUNT_OVERFLOW.getMessage() + message);
        }
    }

    public void checkBonusNumber(List<Integer> winningLotto, int bonusNumber) {
        checkNumberValidation(bonusNumber);
        if (winningLotto.contains(bonusNumber)) {
            throw new RuntimeException(ExceptionMessage.NUMBER_OVERLAP.getMessage());
        }
    }
}
