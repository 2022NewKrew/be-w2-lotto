package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {
    public static List<Integer> generateRandomNumbers(int count, int maxNumber){
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0,count);
        Collections.sort(numbers);
        return numbers;
    }

}

