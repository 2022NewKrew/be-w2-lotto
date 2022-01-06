package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.util.LotteryConfigs.NUMBERS_LENGTH;
import static domain.util.LotteryConfigs.NUMBERS_DOMAIN;

public class LotteryNumbersFactory {
    private final static List<Integer> NUMBERS_DOMAIN_AS_LIST = new ArrayList<>(NUMBERS_DOMAIN);

    public List<Integer> getRandomNumbers() {
        Collections.shuffle(NUMBERS_DOMAIN_AS_LIST);
        List<Integer> numbers = new ArrayList<>(NUMBERS_DOMAIN_AS_LIST.subList(0, NUMBERS_LENGTH));
        Collections.sort(numbers);
        return numbers;
    }
}
