package domain.entity;

import domain.Const;
import view.InputManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto() {
        List<Integer> numbers = getRandomNums();
        lottoNumbers = numbers.subList(0, Const.NUM_OF_LOTTO_NUMS);
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private List<Integer> getRandomNums() {
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<46; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        // [3, 8, 27, 30, 35, 44]
        StringBuilder result = new StringBuilder();
        result.append("[");
        int i=0;
        for (; i < lottoNumbers.size() -1; i++) {
            result.append(lottoNumbers.get(i));
            result.append(", ");
        }
        result.append(lottoNumbers.get(i));
        result.append("]");
        return result.toString();
    }
}
