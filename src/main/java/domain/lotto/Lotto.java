package domain.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private Integer matchedNum;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.matchedNum = null;
    }

    public int getNumOfMatched(List<Integer> winLottoNumbers) {
        if (matchedNum != null) {
            return matchedNum;
        }

        matchedNum = 0;
        for (Integer number : numbers) {
            plusIfMatched(number, winLottoNumbers);
        }
        return matchedNum;
    }

    private void plusIfMatched(int number, List<Integer> winLottoNumbers) {
        if (winLottoNumbers.contains(number)) {
            matchedNum++;
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
