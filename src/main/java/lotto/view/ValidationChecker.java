package lotto.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoSimulator.LOTTO_PRICE;
import static lotto.domain.LottoAutoGenerator.*;

public class ValidationChecker {
    public static final int NUM_OF_DIGITS_IN_LOTTO = 6;

    public boolean checkPositiveNumber(int num) {
        return num >= 0;
    }

    public boolean checkPositiveNumber(long num) {
        return num >= 0;
    }

    public boolean checkAmountUnit(long purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE == 0;
    }

    public boolean checkDigitsInLotto(List<Integer> digitList) {
        return digitList.stream().allMatch(this::checkDigit);
    }

    public boolean checkDigit(int digit) {
        return MIN_DIGIT <= digit && digit <= MAX_DIGIT;
    }

    public boolean checkDuplication(List<Integer> digitList) {
        Set<Integer> digitSet = new HashSet<>(digitList);

        return digitList.size() == digitSet.size();
    }

    public boolean checkDuplication(List<Integer> digitList, int additionalDigit) {
        List<Integer> tmpList = new ArrayList<>(digitList);
        tmpList.add(additionalDigit);
        return checkDuplication(tmpList);
    }

    public boolean checkNumOfDigits(List<Integer> digitList) {
        return digitList.size() == NUM_OF_DIGITS_IN_LOTTO;
    }
}
