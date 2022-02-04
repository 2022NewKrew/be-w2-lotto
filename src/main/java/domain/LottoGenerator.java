package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final List<Integer> BALLS;

    static {
        BALLS = Stream.iterate(1, n -> n + 1)
                .limit(45)
                .collect(Collectors.toList());
    }

    public static List<Integer> createNumbers() {
        List<Integer> numbers;

        Collections.shuffle(BALLS);
        numbers = BALLS.subList(0, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
