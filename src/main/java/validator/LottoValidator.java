package validator;

import domain.Ball;
import domain.Lotto;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {
    public static void assertValidNumber(int number) throws IllegalArgumentException {
        if (number < Ball.MIN_LOTTO_NUMBER || number > Ball.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void assertValidBalls(List<Ball> balls) throws IllegalArgumentException {
        HashSet<Ball> ballHashSet = new HashSet<>(balls);
        int size = ballHashSet.size();
        if (size != Lotto.NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void assertValidBonusBall(List<Ball> balls, Ball bonusBall) throws IllegalArgumentException {
        if (balls.stream().anyMatch(e -> e.getNumber() == bonusBall.getNumber())) {
            throw new IllegalArgumentException();
        }
    }
}
