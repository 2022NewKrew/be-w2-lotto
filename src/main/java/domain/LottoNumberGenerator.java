package domain;

import java.util.*;

public class LottoNumberGenerator {
    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final Integer MAX_NUMBER = 45;

    public static List<Integer> generate() {
        Set<Integer> numbers = new TreeSet<>(); // 정렬하려고 TreeSet 사용했습니다.

        while (numbers.size() < LOTTO_NUMBER_SIZE) {
            numbers.add(getRandomNumber());
        }

        return new ArrayList<>(numbers);
    }

    private static Integer getRandomNumber() {
        return (int) (Math.random() * MAX_NUMBER + 1);
    }
}
