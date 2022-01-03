package domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<46; i++) numbers.add(i);
        Collections.shuffle(numbers);
        lottoNumbers = numbers.subList(0, 5);
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
