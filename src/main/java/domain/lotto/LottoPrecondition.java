package domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoPrecondition {

    public static final int LEGAL_LENGTH_OF_NUMBERS = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    static public void checkNumbers(List<Integer> numbers){
        checkNumbersLength(numbers);
        checkDuplicateNumber(numbers);
        hasOnlyLegalNumber(numbers);
    }

    static private void checkNumbersLength(List<Integer> numbers){
        if(numbers.size() != LEGAL_LENGTH_OF_NUMBERS){
            throw new IllegalArgumentException("숫자의 개수가 부적절합니다!");
        }
    }

    static private void hasOnlyLegalNumber(List<Integer> numbers){
        if(hasLegalNumber(numbers)){
            throw new IllegalArgumentException("숫자는 1 ~ 45 사이의 정수여야 합니다.");
        }
    }

    static private void checkDuplicateNumber(List<Integer> numbers){
        Set<Integer> testSet = new HashSet<>(numbers);
        if (testSet.size() != numbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    static private boolean hasLegalNumber(List<Integer> numbers){
        return numbers.stream().anyMatch(number->number > MAX_NUMBER || number < MIN_NUMBER);
    }
}
