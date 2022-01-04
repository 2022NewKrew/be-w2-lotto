package be.w2.lotto.lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastWinningLotto extends Lotto {

    protected LastWinningLotto(List<LottoNumber> numbers) {
        super(numbers);
    }

    public static LastWinningLotto of(String str) {
        List<LottoNumber> numbers = convertStringToListOfNumbers(str);
        Collections.sort(numbers);
        return new LastWinningLotto(numbers);
    }

    private static List<LottoNumber> convertStringToListOfNumbers(String str) {
        String[] stringsOfNumber = str.split(",", Lotto.LENGTH);
        List<LottoNumber> numbers = new ArrayList<>(stringsOfNumber.length);
        for (String stringOfNumber : stringsOfNumber) {
            numbers.add(LottoNumber.of(stringOfNumber));
        }
        return numbers;
    }

    public int getHowManyCorrect(Lotto myLotto) {
        int howManyCorrect = 0;
        for (LottoNumber number : numbers) {
            if (myLotto.isContain(number)) howManyCorrect++;
        }
        return howManyCorrect;
    }
}
