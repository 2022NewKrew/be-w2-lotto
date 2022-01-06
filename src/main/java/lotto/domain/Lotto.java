package lotto.domain;

import lotto.DuplicationException;
import lotto.NumOfLottoNumbersMismatchException;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int NUM_OF_LOTTO_NUMBERS_IN_LOTTO = 6;

    private final List<LottoNumber> numberList;

    public Lotto(List<LottoNumber> numberList) throws NumOfLottoNumbersMismatchException, DuplicationException {
        checkNumOfLottoNumbers(numberList);
        checkDuplicationInLotto(numberList);
        this.numberList = numberList;
    }

    private void checkNumOfLottoNumbers(@NotNull List<LottoNumber> lottoNumberList) throws NumOfLottoNumbersMismatchException {
        if (lottoNumberList.size() != NUM_OF_LOTTO_NUMBERS_IN_LOTTO) {
            throw new NumOfLottoNumbersMismatchException();
        }
    }

    private void checkDuplicationInLotto(List<LottoNumber> lottoNumberList) throws DuplicationException {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != lottoNumberSet.size()) {
            throw new DuplicationException();
        }
    }

    public List<LottoNumber> getNumberList() {
        return Collections.unmodifiableList(numberList);
    }

    public int getNumOfMatchingNumbersWith(Lotto lotto) {
        HashSet<LottoNumber> lottoNumberSet = new HashSet<>(numberList);
        lottoNumberSet.retainAll(new HashSet<>(lotto.getNumberList()));
        return lottoNumberSet.size();
    }

    public boolean containsLottoNumber(LottoNumber number) {
        return numberList.stream().anyMatch(n -> n.equals(number));
    }
}
