package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class LotteryConstants {
    static final int maxNumber = 45;
    static final int minMatchForPrize = 3;
    static final int ticketLength = 6;
    static final Map<Integer, Integer> prizeMoney = initMap();

    static Map<Integer, Integer> initMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 5000);
        map.put(4, 50000);
        map.put(5, 1500000);
        map.put(6, 2000000000);
        return Collections.unmodifiableMap(map);
    }
}
