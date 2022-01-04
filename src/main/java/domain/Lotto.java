package domain;
import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    private final ArrayList<Integer> numbers;

    public Lotto(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }
}
