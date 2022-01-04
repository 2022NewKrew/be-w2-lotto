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
        if (Prize.SECOND.matchCount == matchedCount && hasBonusNumber(winning)) return Prize.SECOND;
        if (Prize.THIRD.matchCount == matchedCount) return Prize.THIRD;
        if (Prize.FOURTH.matchCount == matchedCount) return Prize.FOURTH;
        if (Prize.FIFTH.matchCount == matchedCount) return Prize.FIFTH;
        return Prize.BLANK;
    }

    private boolean hasBonusNumber(Winning winning) {
        return numbers.contains(winning.getBonusNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
