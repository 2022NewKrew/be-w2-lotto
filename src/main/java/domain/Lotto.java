package domain;

import exception.LottoAmountLimitException;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateAmount(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateAmount(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoAmountLimitException("로또 번호는 오직 6개만 가능합니다.");
        }
    }
}
