package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final List<Integer> BALLS = Stream.iterate(1, n->n+1)
                                                    .limit(45)
                                                    .collect(Collectors.toList());
    private final ArrayList<Integer> numbers;

    public Lotto() {
        Collections.shuffle(BALLS);
        numbers = new ArrayList<>(BALLS.subList(0,6));
        Collections.sort(numbers);
    }

    @Override
    public String toString(){
        return numbers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }

    public int sameWithWinningNum(List<Integer> winningNum){
        return (int) numbers.stream()
                        .filter(winningNum::contains)
                        .count();
    }
}
