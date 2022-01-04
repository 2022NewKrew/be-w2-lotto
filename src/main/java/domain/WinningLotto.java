package domain;

import exception.LottoAmountLimitException;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private List<Integer> numbers;

    public WinningLotto() {
        this.numbers = new ArrayList<>();
    }

    public void setNumbers(List<Integer> numbers) {
        validateLottoAmount(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateLottoAmount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoAmountLimitException("로또 번호는 6개입니다.");
        }
    }

    public void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number.intValue() < LOTTO_NUMBER_MIN || number.intValue() > LOTTO_NUMBER_MAX) {
                throw new LottoAmountLimitException("로또 번호의 범위는 1~45 입니다.");
            }
        }
    }
}
