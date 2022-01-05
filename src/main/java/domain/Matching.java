package domain;

import java.util.*;
import java.util.stream.Collectors;

import static domain.Prize.*;
import static domain.Prize.FIFTH_PRIZE;

public class Matching {

    private EnumMap<Prize, Long> matchingMap = new EnumMap<>(Prize.class);

    /*NO_PRIZE 는 초기값으로 넣어줄 필요가 없다.*/
    public Matching() {
        for (Prize prize : Prize.values()) {
            addInitialMathingMap(prize);
        }
    }

    public Long getPrizeCount(Prize prize) {
        return matchingMap.get(prize);
    }

    public void addInitialMathingMap(Prize prize)
    {
        if(prize == NO_PRIZE)
            return;
        matchingMap.putIfAbsent(prize, 0L);
    }
    public void addMatchingMap(Prize prize) {
        if(prize == NO_PRIZE)
            return;
        matchingMap.put(prize, matchingMap.get(prize) + 1);
    }

    public EnumMap<Prize, Long> getMatchingMap() {
        return matchingMap;
    }

    public long getTotalPrizeSum() {
        return matchingMap.entrySet().stream().map(e -> e.getKey().getPrizeMoney() * e.getValue()).
                mapToLong(Long::longValue).sum();
    }
}