package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final List<Integer> numbers = new ArrayList(45);
    private static final int LOTTO_LENGTH = 6;

    static {
        for(int i = 1; i <= 45; i++) numbers.add(i);
    }

    public static Lotto generateLottoAuto() {
        Collections.shuffle(numbers);
        return new Lotto(new ArrayList(numbers.subList(0, LOTTO_LENGTH)));
    }
}
