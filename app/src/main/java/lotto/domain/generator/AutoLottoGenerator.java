package lotto.domain.generator;

import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.Collections;

public class AutoLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        Collections.shuffle(numbers);
        return new Lotto(new ArrayList<>(numbers.subList(0, Lotto.LENGTH)));
    }
}
