package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberOfValues(numbers.size());
        for(Integer number : numbers){
            validateOneValue(number);
        }
    }

    private void validateNumberOfValues(int numberOfValue){
        if(numberOfValue != Lotto.NUMBER_OF_WRITE_NUMBER){
            throw new IllegalArgumentException(
                    "당첨번호의 갯수는 ".concat(String.valueOf(Lotto.NUMBER_OF_WRITE_NUMBER)).concat("개 입력해주세요."));
        }
    }

    private void validateOneValue(Integer number) throws IllegalArgumentException{
        if(number <= 0 || number > 45){
            throw new IllegalArgumentException("당첨번호는 1이상 45 이하입니다.");
        }
    }

    public int getMatchedNumber(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        if(lottoNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("당첨번호의 갯수와 로또번호의 갯수가 다릅니다.");
        }

        int matchedNumber = 0;
        for(int i=0; i<numbers.size(); i++){
            matchedNumber += numOfSame(numbers.get(i), lottoNumbers.get(i));
        }
        return matchedNumber;
    }

    private int numOfSame(int number1, int number2){
        if(number1 == number2){
            return 1;
        }

        return 0;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
