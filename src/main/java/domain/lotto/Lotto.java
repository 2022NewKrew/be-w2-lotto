package domain.lotto;

import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    public static final int START_NUMBER = 1;
    public static final int FINAL_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoPrecondition.checkNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
