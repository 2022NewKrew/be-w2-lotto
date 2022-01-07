package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private final List<Ball> balls;
    private final Ball bonusBall;

    private WinningLotto(List<Ball> balls, Ball bonusBall) {
        assertValidBalls(balls);
        assertValidBonusBall(balls, bonusBall);
        this.balls = balls;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto create(List<Ball> balls, Ball bonusBall) {
        return new WinningLotto(balls, bonusBall);
    }

    private void assertValidBalls(List<Ball> balls) throws IllegalArgumentException {
        if (new HashSet<>(balls).size() != Lotto.NUMBER_OF_BALLS) {
            throw new IllegalArgumentException();
        }
    }

    private void assertValidBonusBall(List<Ball> balls, Ball bonusBall) throws IllegalArgumentException {
        if (balls.stream().anyMatch(e -> e.getNumber() == bonusBall.getNumber())) {
            throw new IllegalArgumentException();
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

    public boolean checkBonusBallMatched(Lotto lotto) {
        return lotto.containBall(bonusBall);
    }
}
