package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final List<Integer> numbers = new ArrayList(45);

    static {
        for(int i = 1; i <= 45; i++) numbers.add(i);
    }

    public static final Lotto generateLotto() {
        Collections.shuffle(numbers);
        return new Lotto(getSubListFromNumbers());
    }

    private static final List<Integer> getSubListFromNumbers() {
        return new ArrayList(numbers.subList(0,5));
    }
}
