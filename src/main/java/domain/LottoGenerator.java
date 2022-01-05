package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static view.InputView.END_NUMBER;
import static view.InputView.START_NUMBER;

public class LottoGenerator {
    private static List<Integer> shuffleNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());

    public static List<Integer> getLottoNumbers() {
        Collections.shuffle(shuffleNumbers);
        List<Integer> lottoNums = new ArrayList<>(shuffleNumbers.subList(0,6));

        Collections.sort(lottoNums);
        return lottoNums;
    }
}