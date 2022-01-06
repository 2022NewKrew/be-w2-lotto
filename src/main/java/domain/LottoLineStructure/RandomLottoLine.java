package domain.LottoLineStructure;

import domain.LottoLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoLine implements LottoLine {
    public List<Integer> lottoLine;

    public RandomLottoLine() {
        List<Integer> fullNumbers = IntStream.range(MIN_NUM, MAX_NUM + 1).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(fullNumbers);


        lottoLine = fullNumbers.subList(0, NUM_PER_LINE);
        Collections.sort(lottoLine);
    }

    public int checkWinning(List<Integer> winningNumbers) {
        int matchNum = 0;

        for (int num : winningNumbers) {
            matchNum += lottoLine.contains(num) ? 1 : 0;
        }

        return matchNum;
    }

    public List<Integer> getLottoLine() {
        return new ArrayList<>(lottoLine);
    }

    public String getPrintLine() {
        return lottoLine.toString();
    }
}
