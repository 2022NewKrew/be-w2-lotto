package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.Constants.*;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        if(!isPerfectLottoNumbers(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_MESSAGE);
        }
        this.numbers = numbers;
    }

    private boolean isPerfectLottoNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = numbers.stream()
                .filter(num -> LOTTO_START_NUMBER <= num && num <= LOTTO_END_NUMBER)
                .collect(Collectors.toSet());

        return numberSet.size() == NUM_OF_WINNING_NUMBERS;
    }


    /*
    현재 로또 번호 안에 당첨 번호가 몇 개 들어있는지 반환하는 메서드
     */
    public int getResult(List<Integer> winningNumbers) {
        long matched = winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();

        return (int) matched;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
