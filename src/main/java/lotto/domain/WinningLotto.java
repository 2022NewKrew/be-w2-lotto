package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> numberList;
    private final LottoNumber bonusDigit;

    public WinningLotto(List<LottoNumber> numberList, LottoNumber bonusDigit) {
        DomainValidationChecker checker = new DomainValidationChecker();
        checker.checkNumOfDigits(numberList);
        checker.checkDigitsInWinningLotto(numberList, bonusDigit);
        checker.checkDuplicationInWinningLotto(numberList, bonusDigit);
        this.numberList = numberList;
        this.bonusDigit = bonusDigit;
    }

    public LottoNumber getBonusDigit() {
        return bonusDigit;
    }

    public boolean containsLottoNumber(LottoNumber lottoNumber) {
        return numberList.stream().anyMatch(number -> number.getDigit() == lottoNumber.getDigit());
    }
}
