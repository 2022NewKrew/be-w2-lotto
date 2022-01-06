package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.LottoGrade.*;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(String winningNumbers, int bonusNumber){
        numbers = new ArrayList<>();
        for(String number : winningNumbers.split(", ")){
            numbers.add(Integer.parseInt(number));
        }
        Collections.sort(numbers);

        this.bonusNumber = bonusNumber;
    }

    public LottoGrade confirmWinning(Lotto lotto){
        int hitNum = 0;
        boolean isBonusBumberHit = false;

        for(int winningLottoNumber : numbers){
            hitNum += lotto.contain(winningLottoNumber);
        }
        if(lotto.contain(bonusNumber) == 1) isBonusBumberHit = true;

        return calculateGrade(hitNum, isBonusBumberHit);
    }

    private LottoGrade calculateGrade(int hitNum, boolean isBonusBumberHit) {
        if(hitNum == 6) return FIRST;
        if(hitNum == 5 && isBonusBumberHit) return SECOND;
        if(hitNum == 5) return THIRD;
        if(hitNum == 4) return FORTH;
        if(hitNum == 3) return FIFTH;
        return SIXTH;
    }
}
