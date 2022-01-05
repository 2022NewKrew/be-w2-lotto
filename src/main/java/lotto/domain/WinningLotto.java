package lotto.domain;

import java.util.Collections;
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

    public List<LottoNumber> getNumberList() {
        return Collections.unmodifiableList(numberList);
    }

    public LottoNumber getBonusDigit() {
        return bonusDigit;
    }
}
