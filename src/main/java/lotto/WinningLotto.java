package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto {
    public WinningLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public int countMatch(Lotto lotto) {
        int count = 0;
        for (int number: lotto.lottoNumbers) {
            if(lottoNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
