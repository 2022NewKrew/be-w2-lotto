package com.upperleaf.domain.lotto;

import com.upperleaf.domain.lotto.create.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 당첨 번호를 표현하는 객체
 * 6개의 당첨번호와 1개의 보너스 번호를 포함
 */
public class LottoWinningNumber {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validation(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoWinningNumber(String winningNumberString, int bonusNumber) {
        List<Integer> winningNumbers = splitNumbers(winningNumberString);
        validation(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> splitNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean containsWinningNumber(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isEqualToBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }

    private void validation(List<Integer> winningNumbers, int bonusNumber) {
        LottoValidator.validation(winningNumbers);
        LottoValidator.validLottoNumRange(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
