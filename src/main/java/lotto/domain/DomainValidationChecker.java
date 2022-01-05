package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoAutoGenerator.MAX_NUMBER;
import static lotto.domain.LottoAutoGenerator.MIN_NUMBER;

public class DomainValidationChecker {
    public static final int NUM_OF_LOTTO_NUMBERS_IN_LOTTO = 6;

    public void checkLottoNumbersInLotto(@NotNull List<LottoNumber> lottoNumberList) {
        if (!lottoNumberList.stream().allMatch(this::checkLottoNumber))
            throw new IllegalArgumentException("각 번호는 1~45 사이의 숫자 값을 가져야 합니다.");
    }

    public boolean checkLottoNumber(@NotNull LottoNumber lottoNumber) {
        return MIN_NUMBER <= lottoNumber.getNumber() && lottoNumber.getNumber() <= MAX_NUMBER;
    }

    public void checkDuplicationInLotto(List<LottoNumber> lottoNumberList) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberList.size() != lottoNumberSet.size()) {
            throw new IllegalArgumentException("각 번호는 서로 중복될 수 없습니다.");
        }
    }

    public void checkDuplicationInWinningLotto(Lotto lotto, LottoNumber bonusNumber) throws IllegalArgumentException {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lotto.getNumberList());
        lottoNumberList.add(bonusNumber);
        checkDuplicationInLotto(lottoNumberList);
    }

    public void checkNumOfLottoNumbers(@NotNull List<LottoNumber> lottoNumberList) {
        if (lottoNumberList.size() != NUM_OF_LOTTO_NUMBERS_IN_LOTTO) {
            throw new IllegalArgumentException("번호는 " + NUM_OF_LOTTO_NUMBERS_IN_LOTTO + "개를 입력해야 합니다.");
        }
    }
}
