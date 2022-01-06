package validator;

import domain.Ball;
import domain.Lotto;
import domain.Purchase;

import java.util.List;

public class ScannerValidator {
    public static final String ILLEGAL_NUMBERS_MESSAGE = "[ERROR] 1~45 사이의 서로 다른 숫자를 입력해 주세요.\n";
    public static final String ILLEGAL_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 1000원 단위의 숫자를 입력해 주세요.\n";
    public static final String ILLEGAL_BONUS_BALL = "[ERROR] 당첨 번호와 다른 숫자를 입력해 주세요.\n";

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

    public static void assertDuplicatedBallNumber(List<Ball> ballList, int newBallNumber) {
        if (new Lotto(ballList).containBall(new Ball(newBallNumber))) {
            throw new IllegalArgumentException(ILLEGAL_BONUS_BALL);
        }
    }
}
