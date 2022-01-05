package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final List<Integer> BALLS;
    private final List<Integer> numbers;

    static {
        BALLS = Stream.iterate(1, n -> n + 1)
                .limit(45)
                .collect(Collectors.toList());
    }

    public Lotto() {
        Collections.shuffle(BALLS);
        numbers = new ArrayList<>(BALLS.subList(0, 6));
        Collections.sort(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }

    public int sameWithWinningNum(Lotto winningNum) {
        return (int) numbers.stream()
                .filter(winningNum::contains)
                .count();
    }

    public boolean contains(Integer i) {
        return numbers.contains(i);
    }

    public boolean containBonusNum(int bonusNum) {
        return numbers.contains(bonusNum);
    }
}
