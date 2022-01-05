package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Const {
    public static final int NUM_OF_LOTTO_NUMS = 6;
    public static final int PRICE_OF_LOTTO = 1000;
    public static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
}
