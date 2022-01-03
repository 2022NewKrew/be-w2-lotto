package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    public Lotto(){
    }

    public static List<Integer> getRandLotto() {
        Collections.shuffle(range);
        List<Integer> oneLotto = new ArrayList<>(range.subList(0,6));
        return oneLotto;
    }

}
