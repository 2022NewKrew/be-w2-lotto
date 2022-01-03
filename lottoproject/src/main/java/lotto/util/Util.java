package lotto.util;

import java.util.*;

public class Util {
    public static Map<Integer,Integer> reward = new HashMap<Integer,Integer>(){{
        put(3,5000);
        put(4,50000);
        put(5,1500000);
        put(6,2000000000);
    }};

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

