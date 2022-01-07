package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int NUMBER_OF_BALLS = 6;
    private final List<Ball> balls;

    private Lotto(List<Ball> balls) {
        assertValidBalls(balls);
        this.balls = balls;
    }

    public static Lotto create(List<Ball> balls) {
        return new Lotto(balls);
    }

    private void assertValidBalls(List<Ball> balls) throws IllegalArgumentException {
        if (new HashSet<>(balls).size() != Lotto.NUMBER_OF_BALLS) {
            throw new IllegalArgumentException();
        }
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public boolean containBall(Ball ball) {
        return balls.contains(ball);
    }
}
