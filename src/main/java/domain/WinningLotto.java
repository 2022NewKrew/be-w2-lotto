package domain;

import java.util.List;

public class WinningLotto extends Lotto{
    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public int compareTo(Lotto other) {
        return (int) this.getNumbers().stream()
                .filter(e -> other.getNumbers().contains(e))
                .count();
    }
}
