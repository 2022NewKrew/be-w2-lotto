package be.w2.lotto.lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastWinningLotto extends Lotto {

    protected LastWinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public static LastWinningLotto of(String str) {
        List<Integer> numbers = convertStringToListOfNumbers(str);
        Collections.sort(numbers);
        return new LastWinningLotto(numbers);
    }

    private static List<Integer> convertStringToListOfNumbers(String str) {
        String[] stringsOfNumber = str.split(",", Lotto.LENGTH);
        List<Integer> numbers = new ArrayList<>(stringsOfNumber.length);
        for (String stringOfNumber : stringsOfNumber) {
            numbers.add(Integer.parseInt(stringOfNumber));
        }
        return numbers;
    }

    public int getHowManyCorrect(Lotto myLotto) {
        int howManyCorrect = 0;
        for (int number : numbers) {
            if (myLotto.isContain(number)) howManyCorrect++;
        }
        return howManyCorrect;
    }
}
