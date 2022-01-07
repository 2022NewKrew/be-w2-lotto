package domain;

import util.InputChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 실제 개별 복권 한 줄에 해당하는 클래스
 */
public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(Lotto lotto, InputChecker checker, List<Integer> numbers) {
        checker.checkTicketNumber(lotto, numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public int countMatchedNumber(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
