package be.w2.lotto.lottos;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static int MIN_NUM_IN_LOTTO = 1;
    public static int MAX_NUM_IN_LOTTO = 99;
    public static int LENGTH = 6;

    protected List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public boolean isContain(int target) {
        return numbers.contains(target);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        writeOpenSignTo(sb);
        writeContentsTo(sb);
        writeCloseSignTo(sb);
        return sb.toString();
    }

    private void writeOpenSignTo(StringBuilder sb) {
        sb.append("[");
    }

    private void writeContentsTo(StringBuilder sb) {
        List<String> stringOfNumbers = numbers.stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.toList());
        sb.append(String.join(", ", stringOfNumbers));
    }

    private void writeCloseSignTo(StringBuilder sb) {
        sb.append("]");
    }
}
