package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    public static final List<Integer> BALLS = Stream.iterate(1, n->n+1)
                                                    .limit(45)
                                                    .collect(Collectors.toList());
    public final ArrayList<Integer> numbers;

    public Lotto() {
        Collections.shuffle(BALLS);
        numbers = new ArrayList<>(BALLS.subList(0,6));
        Collections.sort(numbers);
    }
}
