package lotto.validation;

import lotto.exception.IllegalBonusNumberException;
import lotto.exception.IllegalManualPurchaseCountException;
import lotto.exception.IllegalNumberListException;
import lotto.exception.IllegalPurchaseAmountException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.*;

public class InputViewValidation {

    private InputViewValidation() {
        throw new AssertionError();
    }

    public static int purchaseAmountValidation(String input) throws IllegalPurchaseAmountException {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalPurchaseAmountException("구입금액은 숫자로만 입력해주세요.", e);
        }
        if (result < LOTTO_PRICE) {
            throw new IllegalPurchaseAmountException("구입금액이 로또 가격보다 낮습니다.", result);
        }
        return result;
    }

    public static int manualPurchaseCountValidation(String input, int maxCount) throws IllegalManualPurchaseCountException {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalManualPurchaseCountException("구매 수는 숫자로만 입력해주세요.", e);
        }
        if (result < 0) {
            throw new IllegalManualPurchaseCountException("구매 수는 0 이상의 숫자로 입력해주세요.");
        }
        if (result > maxCount) {
            throw new IllegalManualPurchaseCountException("수동으로 구매할 로또가 구매금액을 초과합니다.", result, maxCount);
        }
        return result;
    }

    public static List<Integer> numberListValidation(List<String> input) throws IllegalNumberListException {
        List<Integer> result;
        try {
            result = input.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IllegalNumberListException("로또에는 숫자만 넣어주세요.", e);
        }
        List<Integer> invalidNumberList = result.stream().filter(number -> number > 45 || number < 1).collect(Collectors.toList());
        if (invalidNumberList.size() > 0) {
            throw new IllegalNumberListException("로또에는 범위 내의 숫자를 넣어주세요. ", invalidNumberList);
        }
        if (result.size() != 6) {
            throw new IllegalNumberListException("로또에는 6개의 숫자를 넣어주세요");
        }
        Set<Integer> numberSet = new HashSet<>(result);
        if (numberSet.size() != result.size()) {
            throw new IllegalNumberListException("로또에 중복된 숫자가 있습니다.");
        }
        return result;
    }

    public static int bonusNumberValidation(String input) throws IllegalBonusNumberException {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalBonusNumberException("보너스 볼은 숫자로만 입력해주세요.", e);
        }
        if (result > END || result < START) {
            throw new IllegalBonusNumberException("보너스 볼은 범위 내의 숫자로 입력해주세요. ", result);
        }
        return result;
    }
}
