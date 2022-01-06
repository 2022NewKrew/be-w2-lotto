package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoAutoGenerator.MAX_NUMBER;
import static lotto.domain.LottoAutoGenerator.MIN_NUMBER;

public class Lotto {
    public static final int NUM_OF_LOTTO_NUMBERS_IN_LOTTO = 6;
    public static final String CHECK_LOTTO_NUMBER_MESSAGE = "각 번호는 1~45 사이의 숫자 값을 가져야 합니다.";
    public static final String CHECK_DUPLICATION_MESSAGE = "각 번호는 서로 중복될 수 없습니다.";
    public static final String CHECK_NUM_OF_LOTTO_NUMBERS = "번호는 " + NUM_OF_LOTTO_NUMBERS_IN_LOTTO + "개를 입력해야 합니다.";

    private final List<LottoNumber> numberList;

    public Lotto(List<LottoNumber> numberList) {
        checkNumOfLottoNumbers(numberList);
        checkLottoNumbersInLotto(numberList);
        checkDuplicationInLotto(numberList);
        this.numberList = numberList;
    }

    private void checkNumOfLottoNumbers(@NotNull List<LottoNumber> lottoNumberList) {
        if (lottoNumberList.size() != NUM_OF_LOTTO_NUMBERS_IN_LOTTO) {
            throw new IllegalArgumentException(CHECK_NUM_OF_LOTTO_NUMBERS);
        }
    }

    private void checkLottoNumbersInLotto(@NotNull List<LottoNumber> lottoNumberList) {
        if (!lottoNumberList.stream().allMatch(this::checkLottoNumber))
            throw new IllegalArgumentException(CHECK_LOTTO_NUMBER_MESSAGE);
    }

    private boolean checkLottoNumber(@NotNull LottoNumber lottoNumber) {
        return MIN_NUMBER <= lottoNumber.getNumber() && lottoNumber.getNumber() <= MAX_NUMBER;
    }

    private void checkDuplicationInLotto(List<LottoNumber> lottoNumberList) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != lottoNumberSet.size()) {
            throw new IllegalArgumentException(CHECK_DUPLICATION_MESSAGE);
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

    public boolean containsLottoNumber(LottoNumber bonusNumber) {
        return numberList.stream().anyMatch(number -> number.getNumber() == bonusNumber.getNumber());
    }
}
