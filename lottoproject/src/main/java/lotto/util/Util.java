package lotto.util;

import java.util.*;

public class Util {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_MAX_NUMBER = 45;

    public static List<Integer> generateRandomNumbers(int count, int maxNumber){
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i=1; i<=maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0,count);
        Collections.sort(numbers);
        return numbers;
    }
}

