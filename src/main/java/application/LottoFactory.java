package application;

import domain.Ball;

import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {

    public static List<Ball> createLottoBalls(List<Integer> ballNumbers) {
        return ballNumbers.stream().map(Ball::create).collect(Collectors.toList());
    }

}
