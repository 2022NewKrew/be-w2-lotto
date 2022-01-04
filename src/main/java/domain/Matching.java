package domain;

import java.util.*;
import java.util.stream.Collectors;

import static domain.Prize.*;
import static domain.Prize.FIFTH_PRIZE;

public class Matching {

    private EnumMap<Prize, Long> matchingMap = new EnumMap<>(Prize.class);

    public Matching() {
        for (Prize prize : List.of(FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE)) {
            matchingMap.putIfAbsent(prize, 0L);
        }
    }

    public void addMatchingMap(Prize prize) {
        if(prize == NO_PRIZE)
            return;
        matchingMap.put(prize, matchingMap.get(prize) + 1);
    }

    public EnumMap<Prize, Long> getMatchingMap() {
        return matchingMap;
    }

}