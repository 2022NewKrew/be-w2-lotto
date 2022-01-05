package lotto.view;

import lotto.exception.IllegalBonusNumberException;
import lotto.exception.IllegalManualPurchaseCountException;
import lotto.exception.IllegalNumberListException;
import lotto.exception.IllegalPurchaseAmountException;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.*;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATOR = ", ";

    private InputView() {}

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int userInput;
        try {
            userInput = purchaseAmountValidation(sc.nextLine());
        } catch (IllegalPurchaseAmountException e) {
            System.out.println(e.getMessage());
            userInput = getPurchaseAmount();
        }
        return userInput;
    }

    public static int getManualPurchaseCount(int maximumPurchaseCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int userInput;
        try {
            userInput = manualPurchaseCountValidation(sc.nextLine(), maximumPurchaseCount);
        } catch (IllegalManualPurchaseCountException e) {
            System.out.println(e.getMessage());
            userInput = getManualPurchaseCount(maximumPurchaseCount);
        }
        return userInput;
    }

    public static List<Integer> getManualPurchaseNumberList() {
        return inputToNumberList();
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int userInput;
        try {
            userInput = bonusNumberValidation(sc.nextLine());
        } catch (IllegalBonusNumberException e) {
            System.out.println(e.getMessage());
            userInput = getBonusNumber();
        }
        return userInput;
    }

    public static List<Integer> getWinningNumberList() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputToNumberList();
    }

    private static List<Integer> inputToNumberList() {
        List<Integer> result;
        try {
            result = numberListValidation(Arrays.asList(sc.nextLine().split(SEPARATOR)));
        } catch (IllegalNumberListException e) {
            System.out.println(e.getMessage());
            result = inputToNumberList();
        }
        return result;
    }

    private static int purchaseAmountValidation(String input) throws IllegalPurchaseAmountException {
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

    private static int manualPurchaseCountValidation(String input, int maxCount) throws IllegalManualPurchaseCountException {
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

    private static List<Integer> numberListValidation(List<String> input) throws IllegalNumberListException {
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

    private static int bonusNumberValidation(String input) throws IllegalBonusNumberException {
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
