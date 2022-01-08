package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> rawNumbers) {
        numbers = sortAndAdd(rawNumbers);
    }

    private List<Integer> sortAndAdd(List<Integer> rawNumbers) {
        List<Integer> tempNumbers = new ArrayList<>();
        Collections.sort(rawNumbers);
        tempNumbers.addAll(rawNumbers);
        return Collections.unmodifiableList(tempNumbers);
    }

    public int countNumbersMatch(Lotto prize) {
        return (int) this.numbers.stream().filter(prize::contains).count();
    }

    public boolean contains(int num) {
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
