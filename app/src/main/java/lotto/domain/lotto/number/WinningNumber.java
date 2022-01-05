package lotto.domain.lotto.number;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber extends Numbers {

    public WinningNumber(List<Integer> numbers) {
        super(numbers);
    }

    public boolean isContainWinningNumber(Number number) {
        return numbers.contains(number);
    }
}
