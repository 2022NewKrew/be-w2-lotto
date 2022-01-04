package util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoConst {

    public static final int MAX_LOTTO_COUNT = 6;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(1, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

}
