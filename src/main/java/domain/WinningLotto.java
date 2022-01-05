package domain;

import validator.LottoValidator;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    public static final int NUMBER = 6;
    private final List<Ball> balls;
    private final Ball bonusBall;

    public WinningLotto(List<Ball> balls, Ball bonusBall) {
        LottoValidator.assertValidBalls(balls);
        LottoValidator.assertValidBonusBall(balls, bonusBall);
        this.balls = balls;
        this.bonusBall = bonusBall;
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
