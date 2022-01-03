package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().sorted().collect(Collectors.toUnmodifiableList());
    }

    public Prize getPrize(Winning winning) {
        long matchedCount = winning.getNumbers().stream().filter(numbers::contains).count();

        if (Prize.FIRST.matchCount == matchedCount) return Prize.FIRST;
        if (Prize.SECOND.matchCount == matchedCount) return Prize.SECOND;
        if (Prize.THIRD.matchCount == matchedCount) return Prize.THIRD;
        if (Prize.FOURTH.matchCount == matchedCount) return Prize.FOURTH;
        return Prize.BLANK;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
