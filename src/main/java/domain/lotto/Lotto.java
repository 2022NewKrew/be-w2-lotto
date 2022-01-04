package domain.lotto;

import java.util.List;

import static util.LottoConst.MAX_LOTTO_COUNT;

public class Lotto {

    private final List<Integer> numbers;
    private Integer matchedNum;

    public Lotto(List<Integer> numbers) {
        validateInputNumbers(numbers);
        this.numbers = numbers;
        this.matchedNum = null;
    }

    private void validateInputNumbers(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[에러] 로또 번호는 반드시 6개를 입력해야 합니다.");
        }
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("[에러] 로또 번호는 중복되는 숫자가 없어야 합니다.");
        }
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
