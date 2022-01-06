package application;

import domain.Ball;
import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualGeneratedLottoPurchaser implements LottoPurchaser {
    private final List<List<Integer>> ballList;

    public ManualGeneratedLottoPurchaser(List<List<Integer>> ballList) {
        this.ballList = ballList;
    }

    @Override
    public List<Lotto> generateLotto() {
        return ballList.stream()
                .map(e -> new Lotto(e.stream().map(Ball::new).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
