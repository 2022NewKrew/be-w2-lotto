package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오전 11:08
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Integer matchLottoWithLastWeek(List<Integer> lastWeekWinningNumbers) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.retainAll(lastWeekWinningNumbers);
        return copiedNumbers.size();
    }
}
