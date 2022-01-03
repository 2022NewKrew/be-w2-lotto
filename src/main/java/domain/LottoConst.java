package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoConst {
    public static final Integer LOTTO_PRICE = 1000;
    public static final Map<Integer, Integer> RANK_TO_PRICE = new HashMap<>(){{
            put(3, 5000);
            put(4, 50000);
            put(5, 1500000);
            put(6, 2000000000);
    }};
}
