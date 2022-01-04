package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchScore {
    public static final Map<Integer, Long> PRICES = Map.of(3, 5000L, 4, 50000L, 5, 1500000L, 6, 2000000000L);
    private static final List<Integer> RESULTS = List.of(3, 4, 5, 6);
    private final Map<Integer, Integer> count;

    public MatchScore() {
        count = new HashMap<>();
        for (int e : RESULTS) {
            count.put(e, 0);
        }
    }

    public void increase(int matchCount) {
        count.put(matchCount, count.get(matchCount) + 1);
    }

    public Map<Integer, Integer> getCount() {
        return Collections.unmodifiableMap(count);
    }

    public Long getTotalPrice() {
        long totalPrice = 0;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            totalPrice += e.getValue() * (PRICES.get(e.getKey()));
        }
        return totalPrice;
    }
}
