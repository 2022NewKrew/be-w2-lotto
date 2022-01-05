package validator;

import domain.Ball;
import domain.Lotto;

import java.util.List;

public class LottoValidator {
    public static final String ILLEGAL_NUMBERS_MESSAGE = "[ERROR] 1~45 사이의 서로 다른 숫자를 입력해 주세요.\n";
    public static final String ILLEGAL_BALLS_NUMBER = "[ERROR] " + Lotto.NUMBER + "개의 서로 다른 숫자를 입력해 주세요.\n";
    public static final String ILLEGAL_BONUS_BALL = "[ERROR] 당첨 번호와 다른 숫자를 입력해 주세요.\n";

    public static void assertValidNumber(int number) throws IllegalArgumentException {
        if (number < Ball.MIN_LOTTO_NUMBER || number > Ball.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_NUMBERS_MESSAGE);
        }
    }

    public static void assertValidBalls(List<Ball> balls) throws IllegalArgumentException {
        if ((balls.size() != Lotto.NUMBER)
                || balls.stream().map(Ball::getNumber).distinct().count() != balls.size()) {
            throw new IllegalArgumentException(ILLEGAL_BALLS_NUMBER);
        }
    }

    public static void assertValidBonusBall(List<Ball> balls, Ball bonusBall) throws IllegalArgumentException {
        if (balls.stream().anyMatch(e -> e.getNumber() == bonusBall.getNumber())) {
            throw new IllegalArgumentException(ILLEGAL_BONUS_BALL);
        }
    }
}
