package lotto.view;

import lotto.exception.IllegalBonusNumberException;
import lotto.exception.IllegalManualPurchaseCountException;
import lotto.exception.IllegalNumberListException;
import lotto.exception.IllegalPurchaseAmountException;

import java.util.*;

import static lotto.validation.InputViewValidation.*;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATOR = ", ";

    private InputView() {
        throw new AssertionError();
    }

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
}
