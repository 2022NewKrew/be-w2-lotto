package lotto.model;

import java.util.List;
import java.util.Collections;

/**
 * 로또 한 장의 정보와
 * 로또가 얼마나 맞았는지 확인하는 메소드가 있는 class
 */
public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public final int match(final List<Integer> winningNumbers, final Integer bonusBall) {
        int count = 0;
        for(Integer num : winningNumbers)
            count += lottoNumbers.contains(num) ? 1 : 0;

        // 보너스볼 포함해서 다 맞은 경우(2등)와 구별하기 위해
        // 보너스볼 없이 다 맞은 경우 7개 맞춘 것으로 반환
        if(count == 6)
            return 7;

        if(lottoNumbers.contains(bonusBall))
            count += 1;
        return count;
    }
}
