package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private int bonusNumber;
    private List<Integer> numbers;

    public WinningLotto(String winningNumbers, int bonusNumber){
        numbers = new ArrayList<>();
        for(String number : winningNumbers.split(", ")){
            numbers.add(Integer.parseInt(number));
        }
        Collections.sort(numbers);

        this.bonusNumber = bonusNumber;
    }

    public int confirmWinning(Lotto lotto){
        int hitNum = 0;
        boolean isBonusBumberHit = false;

        for(int winningLottoNumber : numbers){
            hitNum += lotto.contain(winningLottoNumber);
        }
        if(lotto.contain(bonusNumber) == 1) isBonusBumberHit = true;

        return calculateGrade(hitNum, isBonusBumberHit);
    }

    private int calculateGrade(int hitNum, boolean isBonusBumberHit) {
        if(hitNum == 6) return 1;
        if(hitNum == 5 && isBonusBumberHit) return 2;
        if(hitNum == 5) return 3;
        if(hitNum == 4) return 4;
        if(hitNum == 3) return 5;
        return 6;
    }
}
