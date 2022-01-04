package be.w2.lotto.lottos;

import java.util.List;

public class LastWinningLotto extends Lotto {

    public LastWinningLotto(List<LottoNumber> numbers) {
        super(numbers);
    }

    public int getHowManyCorrect(Lotto myLotto) {
        int howManyCorrect = 0;
        for (LottoNumber number : numbers) {
            if (myLotto.isContain(number)) howManyCorrect++;
        }
        return howManyCorrect;
    }
}
