package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class RandomGenerator {
    private List<Integer> totalNumberList;

    public RandomGenerator() {
        totalNumberList = new ArrayList<>();
        for(int i=1; i<=LottoParameter.maxLottoNumber; i++) {
            totalNumberList.add(i);
        }
    }

    public List<Integer> pickRandomNumbers() {
        Collections.shuffle(totalNumberList);
        List<Integer> lottoList = new ArrayList<>();
        for(int i=0; i<LottoParameter.numberOfLottoPicks; i++) {
            lottoList.add(totalNumberList.get(i));
        }
        return lottoList;
    }
}
