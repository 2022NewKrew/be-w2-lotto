package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    public static final int NUMBER = 6;
    public static final String ILLEGAL_BALLS_NUMBER = "[ERROR] " + NUMBER + "개의 서로 다른 숫자를 입력해 주세요.\n";
    private final List<Ball> balls;

    public WinningLotto(List<Ball> balls) {
        assertValidBalls(balls);
        this.balls = balls;
    }

    private void assertValidBalls(List<Ball> balls) throws IllegalArgumentException {
        if ((balls.size() != NUMBER)
                || new HashSet<>(balls).size() != balls.size()) {
            throw new IllegalArgumentException(ILLEGAL_BALLS_NUMBER);
        }
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public int checkNumberOfWinning(Lotto other) {
        return (int) this.getBalls().stream()
                .filter(other::containBall)
                .count();
    }
}
