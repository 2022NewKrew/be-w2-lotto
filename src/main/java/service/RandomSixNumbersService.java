package service;

import constant.LottoConstants;
import domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomSixNumbersService {
    public static List<Integer> getRandomSixNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> allLottoNumbers = lottoNumbers.getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        List<Integer> randomSixNumbers = allLottoNumbers.subList(0, LottoConstants.NUMBERS_PER_LOTTO);
        Collections.sort(randomSixNumbers);
        return randomSixNumbers;
    }
}
