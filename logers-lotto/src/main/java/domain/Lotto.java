package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_OF_WRITE_NUMBER = 6;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new HashSet<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberOfValues(numbers.size());
        validateDuplicate(numbers);
        for(Integer number : numbers){
            validateOneValue(number);
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if(numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void validateNumberOfValues(int numberOfValue){
        if(numberOfValue != Lotto.NUMBER_OF_WRITE_NUMBER){
            throw new IllegalArgumentException(
                    "로또 번호의 갯수는 ".concat(String.valueOf(Lotto.NUMBER_OF_WRITE_NUMBER)).concat("개 입력해주세요."));
        }
    }

    private void validateOneValue(Integer number) throws IllegalArgumentException{
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException("로또 번호는 1이상 45 이하입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
