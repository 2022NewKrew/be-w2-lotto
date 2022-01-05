package lotto.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoAutoGenerator.MAX_DIGIT;
import static lotto.domain.LottoAutoGenerator.MIN_DIGIT;

public class DomainValidationChecker {
    public static final int NUM_OF_DIGITS_IN_LOTTO = 6;

    public void checkDigitsInLotto(@NotNull List<Integer> digitList) {
        if (!digitList.stream().allMatch(this::checkDigit))
            throw new IllegalArgumentException("각 번호는 1~45 사이의 숫자 값을 가져야 합니다.");
    }

    public void checkDigitsInWinningLotto(List<Integer> digitList, int bonusDigit) throws IllegalArgumentException {
        List<Integer> tmpList = new ArrayList<>(digitList);
        tmpList.add(bonusDigit);
        checkDigitsInLotto(tmpList);
    }

    private boolean checkDigit(int digit) {
        return MIN_DIGIT <= digit && digit <= MAX_DIGIT;
    }

    public void checkDuplicationInLotto(List<Integer> digitList) {
        Set<Integer> digitSet = new HashSet<>(digitList);
        if (digitList.size() != digitSet.size()) {
            throw new IllegalArgumentException("각 번호는 서로 중복될 수 없습니다.");
        }
    }

    public void checkDuplicationInWinningLotto(List<Integer> digitList, int additionalDigit) throws IllegalArgumentException {
        List<Integer> tmpList = new ArrayList<>(digitList);
        tmpList.add(additionalDigit);
        checkDuplicationInLotto(tmpList);
    }

    public void checkNumOfDigits(@NotNull List<Integer> digitList) {
        if (digitList.size() != NUM_OF_DIGITS_IN_LOTTO) {
            throw new IllegalArgumentException("번호는 " + NUM_OF_DIGITS_IN_LOTTO + "개를 입력해야 합니다.");
        }
    }
}
