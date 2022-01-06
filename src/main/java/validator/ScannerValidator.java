package validator;

import domain.Ball;
import domain.Lotto;
import domain.Purchase;

import java.util.HashSet;
import java.util.List;

public class ScannerValidator {
    public static final String ILLEGAL_NUMBERS_MESSAGE = "[ERROR] 1~45 사이의 서로 다른 숫자를 입력해 주세요.";
    public static final String ILLEGAL_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 1000원 단위의 숫자를 입력해 주세요.";
    public static final String ILLEGAL_BONUS_BALL = "[ERROR] 당첨 번호와 다른 숫자를 입력해 주세요.";
    public static final String DUPLICATED_BALL_LIST = "[ERROR] 중복되지 않은 숫자 목록을 입력해 주세요.";
    public static final String ILLEGAL_MANUAL_PURCHASE_QUANTITY = "[ERROR] 올바른 구매 숫자를 입력해 주세요.";

    private ScannerValidator() { }

    public static void assertValidNumber(int number) throws IllegalArgumentException {
        if (number < Ball.MIN_LOTTO_NUMBER || number > Ball.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_NUMBERS_MESSAGE);
        }
    }

    public static void assertValidPurchaseAmount(int purchaseAmount) throws NumberFormatException {
        if (((purchaseAmount < 0)) || (purchaseAmount % Purchase.ONE_LOTTO_PRICE) != 0) {
            throw new NumberFormatException(ILLEGAL_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public static void assertValidBallNumbers(List<Integer> balls) throws IllegalArgumentException {
        if (new HashSet<>(balls).size() != Lotto.NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(DUPLICATED_BALL_LIST);
        }
    }

    public static void assertDuplicatedBallNumber(List<Integer> ballList, int newBallNumber) {
        if (ballList.contains(newBallNumber)) {
            throw new IllegalArgumentException(ILLEGAL_BONUS_BALL);
        }
    }

    public static void assertValidManualPurchaseQuantity(int totalPurchaseQuantity, int manualPurchaseQuantity) {
        if (manualPurchaseQuantity < 0 || manualPurchaseQuantity > totalPurchaseQuantity) {
            throw new IllegalArgumentException(ILLEGAL_MANUAL_PURCHASE_QUANTITY);
        }
    }
}
