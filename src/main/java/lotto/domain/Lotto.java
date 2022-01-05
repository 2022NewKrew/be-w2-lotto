package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numberList;

    public Lotto(List<LottoNumber> numberList) {
        DomainValidationChecker checker = new DomainValidationChecker();
        checker.checkNumOfDigits(numberList);
        checker.checkDigitsInLotto(numberList);
        checker.checkDuplicationInLotto(numberList);
        this.numberList = numberList;
    }

    public List<LottoNumber> getNumberList() {
        return Collections.unmodifiableList(numberList);
    }

    public int getNumOfMatchingDigits(@NotNull WinningLotto winningLotto) {
        return (int) numberList.stream()
                .filter(winningLotto::containsLottoNumber)
                .count();
    }

    public boolean containsBonusNumber(LottoNumber bonusNumber) {
        return numberList.stream().anyMatch(number -> number.getDigit() == bonusNumber.getDigit());
    }
}
