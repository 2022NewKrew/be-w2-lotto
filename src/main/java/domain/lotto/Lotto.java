package domain.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private Integer matchedNum;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.matchedNum = null;
    }

    public int getNumOfMatched(Lotto winLotto) {
        if (matchedNum != null) {
            return matchedNum;
        }

        matchedNum = 0;
        for (Integer number : numbers) {
            plusIfMatched(number, winLotto);
        }
        return matchedNum;
    }

    public boolean isBonusMatched(int bonusLottoNumber) {
        return numbers.contains(bonusLottoNumber);
    }

    private void plusIfMatched(int number, Lotto winLotto) {
        if (winLotto.numbers.contains(number)) {
            matchedNum++;
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
