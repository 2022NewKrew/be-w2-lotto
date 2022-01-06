package lotto.domain.player;

import lotto.domain.lotto.Lotto;
import lotto.utils.RandomNumbers;
import lotto.validator.LottoValidator;

import java.util.List;

public class PlayerLotto implements Lotto {

    private final List<Integer> numbers;

    public PlayerLotto() {
        this.numbers = RandomNumbers.getRandomLottoNumbers();
    }

    public PlayerLotto(List<Integer> numbers){
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

}
