package step1.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step1.utils.CommonConstants.*;

public class Lotto {
    private static final List<Integer> AVAIL_LOTTO_NUMS = IntStream
            .range(START_LOTTO_NUM, END_LOTTO_NUM)
            .boxed().collect(Collectors.toList());

    private final List<Integer> lotto;

    public Lotto() {
        Collections.shuffle(AVAIL_LOTTO_NUMS, new Random(System.nanoTime()));
        List<Integer> chosenNumbers = new ArrayList<>(AVAIL_LOTTO_NUMS.subList(0, RESULT_LOTTO_NUM));
        Collections.sort(chosenNumbers);
        this.lotto = chosenNumbers;
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public boolean isContainedThisNumber(int num) {
        return lotto.contains(num);
    }

    @Override
    public String toString() {
        return lotto.toString() + "\n";
    }
}
