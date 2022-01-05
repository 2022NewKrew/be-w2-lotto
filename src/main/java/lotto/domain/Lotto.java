package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numberList;

    public Lotto(List<LottoNumber> numberList) {
        DomainValidationChecker checker = new DomainValidationChecker();
        checker.checkNumOfLottoNumbers(numberList);
        checker.checkLottoNumbersInLotto(numberList);
        checker.checkDuplicationInLotto(numberList);
        this.numberList = numberList;
    }

    public List<LottoNumber> getNumberList() {
        return Collections.unmodifiableList(numberList);
    }

    public int getNumOfMatchingNumbersWith(Lotto lotto) {
        HashSet<LottoNumber> lottoNumberSet = new HashSet<>(numberList);
        lottoNumberSet.retainAll(new HashSet<>(lotto.getNumberList()));
        return lottoNumberSet.size();
    }

    public boolean containsLottoNumber(LottoNumber bonusNumber) {
        return numberList.stream().anyMatch(number -> number.getNumber() == bonusNumber.getNumber());
    }
}
