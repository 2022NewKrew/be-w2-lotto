package parameters;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class LottoLine {
    private final List<Integer> numbers;

    public LottoLine(List<Integer> numbers) { this.numbers = numbers; }

    public Stream<Integer> getNumbersStream() { return numbers.stream(); }
    public String getViewString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for(int number : numbers){
            sj.add(Integer.toString(number));
        }
        return sj.toString();
    }
}
