package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<Integer> templateNumbers = makeTemplateNumbers();

    public static ArrayList<Integer> getRandomLottoNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Collections.shuffle(templateNumbers);
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            randomNumbers.add(templateNumbers.get(i));
        }
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private static ArrayList<Integer> makeTemplateNumbers(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN; i < LOTTO_NUMBER_MAX; i++) {
            list.add(i);
        }
        return list;
    }
}
