package lotto.domain.result;

import lotto.domain.lotto.Lotto;
import lotto.validator.LottoValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto implements Lotto {

    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }
}
