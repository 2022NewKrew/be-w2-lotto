package util;

import domain.Lotto;
import domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomUtil {
    private static final List<Integer> numbers;

    static {
        numbers = IntStream
                .iterate(LottoNumber.MIN_NUMBER, number -> number+1)
                .limit(LottoNumber.MAX_NUMBER)
                .boxed()
                .collect(toList());
    }

    public static List<Integer> createRandomNumbers(){
        Collections.shuffle(numbers);

        List<Integer> randomNumbers
                = new ArrayList<>(numbers.subList(0, Lotto.NUMBER_OF_WRITE_NUMBER));
        Collections.sort(randomNumbers);

        return randomNumbers;
    }
}
