package application;

import domain.Ball;
import domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {
    private final List<Ball> numbers = IntStream.rangeClosed(Ball.MIN_LOTTO_NUMBER, Ball.MAX_LOTTO_NUMBER)
            .mapToObj(Ball::new).collect(Collectors.toList());

    @Override
    public Lotto getLotto() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.stream()
                .distinct()
                .limit(Lotto.NUMBER_OF_BALLS)
                .collect(Collectors.toList()));
    }
}
