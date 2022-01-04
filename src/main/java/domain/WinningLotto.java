package domain;

import java.util.List;

public class WinningLotto extends Lotto{
    public WinningLotto(List<Ball> numbers) {
        super(numbers);
    }

    public int compareTo(Lotto other) {
        return (int) this.getBalls().stream()
                .filter(other::containBall)
                .count();
    }
}
