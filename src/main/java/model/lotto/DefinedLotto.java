package model.lotto;

import model.lotto.number.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class DefinedLotto{
    private final Lotto lotto;

    public DefinedLotto(List<Integer> numbers) {
        lotto = new Lotto(numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int countDuplicateNumberWith(Lotto lotto) {
        return this.lotto.countDuplicateNumberWith(lotto);
    }
}
