package validator;

import domain.Ball;
import domain.Lotto;

import java.util.List;

public class ScannerValidator {
    public static final String ILLEGAL_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 1000원 단위의 숫자를 입력해 주세요.\n";
    public static final String ILLEGAL_BONUS_BALL = "[ERROR] 당첨 번호와 다른 숫자를 입력해 주세요.\n";

    public static void assertValidPurchaseAmount(int purchaseAmount) throws NumberFormatException  {
        if ((purchaseAmount % Lotto.PRICE) != 0) {
            throw new NumberFormatException(ILLEGAL_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public static void assertDuplicatedBallNumber(List<Ball> ballList, int newBallNumber) {
        if (new Lotto(ballList).containBall(new Ball(newBallNumber))) {
            throw new IllegalArgumentException(ILLEGAL_BONUS_BALL);
        }
    }
}
