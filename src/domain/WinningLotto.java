package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> stringToList, int bonusNumber) {
        super(stringToList);
        this.bonusNumber = bonusNumber;
    }

    public boolean mathBonus(Lotto lotto){
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int getCountOfSame(Lotto lotto) {
        Set<Integer> addList = new HashSet<Integer>(lotto.getNumbers());
        addList.addAll(getNumbers());
        return SIZE*2 - addList.size();
    }
}
