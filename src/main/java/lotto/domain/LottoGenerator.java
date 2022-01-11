package lotto.domain;

import lotto.model.Lotto;

import java.util.*;

public class LottoGenerator {
    private static final List<Integer> NUMBERS = new ArrayList<>();

    static{
        for (int i = 0; i < 45; i++) {
            NUMBERS.add((i + 1));
        }
    }

    public static Lotto generateRandomLotto() {
        Set<Integer> numbers = new HashSet<>();

        Collections.shuffle(NUMBERS);
        for (int i = 0; i < 6; i++) {
            numbers.add(NUMBERS.get(i));
        }

        return new Lotto(numbers);
    }

}
