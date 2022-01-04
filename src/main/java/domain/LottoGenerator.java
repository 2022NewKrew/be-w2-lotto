package domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.END_NUMBER;
import static domain.Lotto.START_NUMBER;

public class LottoGenerator {
    private static List<Integer> shuffleNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());

    public static List<Integer> getLottoNumbers() {
        Collections.shuffle(shuffleNumbers);
        List<Integer> lottoNums = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            lottoNums.add(shuffleNumbers.get(i));
        }
        Collections.sort(lottoNums);
        return lottoNums;
    }
}