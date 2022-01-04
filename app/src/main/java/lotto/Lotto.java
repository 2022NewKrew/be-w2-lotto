package lotto;

import java.util.List;
import java.util.Collections;

public class Lotto {
    private final List<Integer> lottoNumbers;

    Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int match(List<Integer> winningNumbers) {
        int count = 0;
        for(Integer num : winningNumbers)
            count += lottoNumbers.contains(num) ? 1 : 0;
        return count;
    }
}
