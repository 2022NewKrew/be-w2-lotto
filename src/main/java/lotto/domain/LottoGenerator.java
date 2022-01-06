package lotto.domain;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final List<Integer> NUMBERS = new ArrayList<>();

    public LottoGenerator() {
        for (int i = 0; i < 45; i++) {
            NUMBERS.add((i + 1));
        }
    }

    public Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>();

        Collections.shuffle(NUMBERS);
        for (int i = 0; i < 6; i++) {
            numbers.add(NUMBERS.get(i));
        }
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

}
