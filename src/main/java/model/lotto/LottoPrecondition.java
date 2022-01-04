package model.lotto;

import model.number.Number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoPrecondition {

    static public void checkNumbers(List<Number> numbers) {
        checkNumbersLength(numbers);
        checkDuplicateNumber(numbers);
    }

    static private void checkNumbersLength(List<Number> numbers) {
        if (numbers.size() != Lotto.LENGTH_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 부적절합니다!");
        }
    }

    static private void checkDuplicateNumber(List<Number> numbers) {
        Set<Number> testSet = new HashSet<>(numbers);
        if (testSet.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }


}
