package domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

import static util.LottoConst.MAX_LOTTO_COUNT;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateInputNumbers(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
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

    public int getNumOfMatched(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContainsNumber)
                .count();
    }

    public boolean isBonusMatched(int bonusLottoNumber) {
        return numbers.contains(bonusLottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
