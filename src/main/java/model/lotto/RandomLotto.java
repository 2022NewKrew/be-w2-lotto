package model.lotto;

import model.number.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLotto extends Lotto {

    private static final List<Number> lottoNumbers =
            IntStream.rangeClosed(Number.START_NUMBER, Number.FINAL_NUMBER)
                    .mapToObj(Number::new)
                    .collect(Collectors.toList());

    public RandomLotto() {
        super.numbers = generateRandomNumbers();
    }

    private List<Number> generateRandomNumbers() {
        Collections.shuffle(lottoNumbers);
        List<Number> targetNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(targetNumbers);
        return targetNumbers;
    }

}
