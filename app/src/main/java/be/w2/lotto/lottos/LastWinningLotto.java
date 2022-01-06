package be.w2.lotto.lottos;

import java.util.List;

public class LastWinningLotto extends Lotto {

    private LottoNumber bonusNumber;

    public LastWinningLotto(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getHowManyCorrect(Lotto myLotto) {
        int howManyCorrect = 0;
        for (LottoNumber number : lottoNumbers) {
            if (myLotto.isContain(number)) howManyCorrect++;
        }
        return howManyCorrect;
    }

    public boolean isContainBonus(Lotto myLotto) {
        return myLotto.isContain(bonusNumber);
    }
}
