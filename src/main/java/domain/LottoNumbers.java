package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> allLottoNumbers = new ArrayList<>();

    public LottoNumbers() {
        for (int i = 1 ; i <= 45 ; i++) {
            this.allLottoNumbers.add(i);
        }
    }

    public List<Integer> getAllLottoNumbers() {
        return allLottoNumbers;
    }
}
