package domain;

import validator.LottoValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int NUMBER = 6;
    public static final int PRICE = 1000;
    private final List<Ball> balls;

    public Lotto(List<Ball> balls) {
        LottoValidator.assertValidBalls(balls);
        this.balls = balls;
    }

    public static int getPurchaseQuantity(int amount) {
        return amount / PRICE;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public boolean containBall(Ball ball) {
        return balls.stream()
                .anyMatch(e -> e.getNumber() == ball.getNumber());
    }
}
