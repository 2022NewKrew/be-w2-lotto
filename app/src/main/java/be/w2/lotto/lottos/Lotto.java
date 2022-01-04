package be.w2.lotto.lottos;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static int LENGTH = 6;

    protected List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public boolean isContain(LottoNumber target) {
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
                .map(num -> num.toString())
                .collect(Collectors.toList());
        sb.append(String.join(", ", stringOfNumbers));
    }

    private void writeCloseSignTo(StringBuilder sb) {
        sb.append("]");
    }
}
