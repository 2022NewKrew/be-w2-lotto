package domain;

import java.util.List;

public class PurchasedLotto implements Lotto {
    private List<Integer> numbers;

    public PurchasedLotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public int getBonusNumber() { return 0; }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
