package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static view.ConsoleInputView.END_NUMBER;
import static view.ConsoleInputView.START_NUMBER;

public class LottoGenerator {
    private static List<Integer> shuffleNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());

    public static List<Integer> generateLottoNumbers() {
        Collections.shuffle(shuffleNumbers);
        List<Integer> lottoNums = new ArrayList<>(shuffleNumbers.subList(0,6));

        Collections.sort(lottoNums);
        return lottoNums;
    }
}