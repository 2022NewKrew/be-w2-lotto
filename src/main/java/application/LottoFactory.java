package application;

import domain.Ball;
import domain.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    private LottoFactory() {
    }

    private static Ball createBall(int number) {
        return new Ball(number);
    }

    private static List<Ball> createLottoBalls(List<Integer> ballNumbers) {
        return ballNumbers.stream().map(Ball::new).collect(Collectors.toList());
    }

    public static WinningLotto createWinningLotto(List<Integer> ballNumbers, int bonusBall) {
        return new WinningLotto(createLottoBalls(ballNumbers), createBall(bonusBall));
    }
}
