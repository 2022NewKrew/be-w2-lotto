package domain;

import java.util.HashMap;

public class LottoParameter {
    public static final int priceForOneLotto = 1000;
    public static final int maxLottoNumber = 45;
    public static final int numberOfLottoPicks = 6;

    public static final RandomGenerator randomGenerator = new RandomGenerator();

    public static final HashMap<Integer, Long> rankToPrice = new HashMap<>() {{
        put(3, 5000L);
        put(4, 50000L);
        put(5, 1500000L);
        put(6, 2000000000L);
    }};

}
