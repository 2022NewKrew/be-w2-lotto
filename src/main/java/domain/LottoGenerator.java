package domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static List<Integer> shuffleNumbers;

    LottoGenerator() {
        this.shuffleNumbers = new ArrayList<Integer>();
        for (int i = 1; i <= 45; i++) {
            shuffleNumbers.add(i);
        }
    }

    public List<Integer> getLottoNumbers() {
        Collections.shuffle(shuffleNumbers);
        List<Integer> lottoNums = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            lottoNums.add(shuffleNumbers.get(i));
        }
        Collections.sort(lottoNums);
        return lottoNums;
    }
}
