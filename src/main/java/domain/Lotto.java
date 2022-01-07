package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers = new ArrayList<>();

    private Lotto(){}
    public Lotto(List<Integer> numbers) {
        sortAndAdd(numbers);
    }

    void sortAndAdd(List<Integer> rawNumbers) {
        Collections.sort(rawNumbers);
        numbers.addAll(rawNumbers);
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
