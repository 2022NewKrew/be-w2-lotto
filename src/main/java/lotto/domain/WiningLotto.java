package lotto.domain;

import lotto.result.LottoRank;

import java.util.List;

public class WiningLotto extends Lotto{

    private int bonusNumber;

    public WiningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoRank matchLotto(Lotto lotto){
        int matchCount = 0;
        boolean isBonusBall = false;
        for (int number : lotto.getNumbers().get()){
            if (contains(number)) matchCount += 1;
            isBonusBall |= bonusNumber == number;
        }
        return LottoRank.valueOf(matchCount, isBonusBall);
    }

}
