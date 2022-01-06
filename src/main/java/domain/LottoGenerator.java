package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUM_OF_DRAWS = 6;
    private static final ArrayList<Integer> NUMBERS = new ArrayList<>(
            IntStream.range(MIN_NUMBER, MAX_NUMBER).boxed()
                    .collect(Collectors.toList())
    );

    public static Lotto generateRandomly() {
        ArrayList<Integer> drawn = new ArrayList<>();
        Collections.shuffle(NUMBERS);
        for (int i = 0; i < NUM_OF_DRAWS; ++i) {
            drawn.add(NUMBERS.get(i));
        }
        Collections.sort(drawn);
        return new Lotto(drawn);
    }
}
