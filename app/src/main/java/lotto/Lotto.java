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

    public int match(List<Integer> winningNumbers, Integer bonusBall) {
        int count = 0;
        for(Integer num : winningNumbers)
            count += lottoNumbers.contains(num) ? 1 : 0;

        if(count == 6)
            return 7;

        if(lottoNumbers.contains(bonusBall))
            count += 1;
        return count;
    }
}
