package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());
    private static final int NUM_OF_DRAWS = 6;
    private final ArrayList<Integer> numbers;

    public Lotto(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto generateRandomly() {
        ArrayList<Integer> drawn = new ArrayList<>();
        Collections.shuffle(NUMBERS);
        for (int i = 0; i < NUM_OF_DRAWS; ++i) {
            drawn.add(NUMBERS.get(i));
        }
        Collections.sort(drawn);
        return new Lotto(drawn);
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
