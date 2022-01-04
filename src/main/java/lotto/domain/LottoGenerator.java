package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;

    private static final Random random = new Random();

    public static List<Integer> generateRandomLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Lotto.LENGTH; i++) {
            int nextNum = i == 0 ? randomNum() : nextNum(numbers);
            numbers.add(nextNum);
        }
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    private static int randomNum() {
        return random.nextInt(MAX_NUM - MIN_NUM) + MIN_NUM;
    }

    private static int nextNum(List<Integer> numbers) {
        int result = numbers.get(0);
        while (numbers.contains(result)) {
            result = randomNum();
        }
        return result;
    }
}
