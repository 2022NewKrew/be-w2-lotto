package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER = 6;
    public static final int PRICE = 1000;
    public static final String ILLEGAL_BALLS_NUMBER = "[ERROR] " + NUMBER + "개의 서로 다른 숫자를 입력해 주세요.\n";
    private final List<Ball> balls;

    public Lotto(List<Ball> balls) {
        assertValidBalls(balls);
        this.balls = balls;
    }

    private void assertValidBalls(List<Ball> balls) throws IllegalArgumentException {
        if ((balls.size() != NUMBER)
                || balls.stream().map(Ball::getNumber).distinct().count() != balls.size()) {
            throw new IllegalArgumentException(ILLEGAL_BALLS_NUMBER);
        }
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
