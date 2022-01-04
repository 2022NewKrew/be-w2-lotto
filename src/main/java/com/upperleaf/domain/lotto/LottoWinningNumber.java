package com.upperleaf.domain.lotto;

import java.util.List;

/**
 * 로또 당첨 번호를 표현하는 객체
 * 6개의 당첨번호와 1개의 보너스 번호를 포함
 */
public class LottoWinningNumber {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean containsWinningNumber(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isEqualToBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }
}
