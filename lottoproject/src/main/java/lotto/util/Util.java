package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MIN_NUMBER = 1;

    public static List<Integer> generateRandomNumbers(int count, int minNumber, int maxNumber){
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i=minNumber; i<=maxNumber; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0,count);
        Collections.sort(numbers);
        return numbers;
    }

    public static List<Integer> generateLottoRandomNumbers(){
        return generateRandomNumbers(Util.LOTTO_NUMBER_COUNT, Util.LOTTO_MIN_NUMBER, Util.LOTTO_MAX_NUMBER);
    }
    public static List<Integer> convStringToIntegerArraylist(String input, String gubun){
        List<Integer> inputIntegerArrayList = new ArrayList<>();
        for (String string : input.split(gubun)){
            inputIntegerArrayList.add(Integer.parseInt(string));
        }
        return inputIntegerArrayList;
    }
}

