package domain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> fixedNumbers = IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());
    private final ArrayList<Integer> numbers;

    public Lotto() {
        Collections.shuffle(fixedNumbers);
        numbers = new ArrayList<>(fixedNumbers.subList(0, LOTTO_SIZE));
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
