package com.cold.models;

import java.util.List;

import lombok.Getter;

@Getter
public class WinningLotto {
    private String INVALID_LAST_WINNING_NUMS_RANGE = "당첨 번호 범위 오류";
    private String INVALID_LAST_WINNING_NUMS_COUNT = "지난 주 당첨 번호 갯수 오류";

    private Integer NUMS_OF_LOTTO_NUMBERS = 6;
    private Integer MIN_LOTTO_NUMBER = 1;
    private Integer MAX_LOTTO_NUMBER = 45;

    private List<Integer> lastWinningNums;
    private Integer bonusBall;

    public WinningLotto(List<Integer> lastWinningNums, Integer bonusNumber) throws IllegalArgumentException {
        validateRangeEachNum(bonusNumber);
        this.bonusBall = bonusNumber;
        validateLastWinningNums(lastWinningNums);
        this.lastWinningNums = lastWinningNums;
    }

    public void validateLastWinningNums(List<Integer> lastWinningNums) throws IllegalArgumentException {
        validateCount(lastWinningNums);
        validateRange(lastWinningNums);
    }

    private void validateRange(List<Integer> lastWinningNums) throws IllegalArgumentException {
        for (Integer num : lastWinningNums) {
            validateRangeEachNum(num);
        }
    }

    private void validateRangeEachNum(int num) throws IllegalArgumentException {
        if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LAST_WINNING_NUMS_RANGE);
        }
    }

    public void validateCount(List<Integer> lastWinningNums) throws IllegalArgumentException {
        if (lastWinningNums.size() != NUMS_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(INVALID_LAST_WINNING_NUMS_COUNT);
        }
    }


}
