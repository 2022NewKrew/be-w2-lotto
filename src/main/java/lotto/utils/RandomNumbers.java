package lotto.utils;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    private static final List<Integer> templateNumbers = makeTemplateNumbers();

    public static ArrayList<Integer> getRandomLottoNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Collections.shuffle(templateNumbers);
        for (int i = 0; i < Lotto.LOTTO_NUMBER_COUNT_MAX; i++) {
            randomNumbers.add(templateNumbers.get(i));
        }
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private static ArrayList<Integer> makeTemplateNumbers(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = Lotto.LOTTO_NUMBER_MIN; i < Lotto.LOTTO_NUMBER_MAX; i++) {
            list.add(i);
        }
        return list;
    }
}
