package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        Validator.validate(numbers, bonusNumber);

        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
        this.bonusNumber = bonusNumber;
    }

    public RewardType getMatchedNumber(List<Integer> numbers){
        int matched = numbers.stream()
                .map(this.numbers::contains)
                .mapToInt(isInside -> isInside ? 1 : 0)
                .reduce(Integer::sum).getAsInt();

        return RewardType.getRewardType(matched, numbers.contains(bonusNumber));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static class Validator{
        static void validate(List<Integer> numbers, int bonusNumber) {
            validateNumbers(numbers);
            validateBonusNumber(numbers, bonusNumber);
        }

        static void validateNumbers(List<Integer> numbers){
            validateSize(numbers.size());
            for(Integer number : numbers){
                validateOneNumber(number);
            }
        }

        static void validateBonusNumber(List<Integer> numbers, int bonusNumber){
            validateOneNumber(bonusNumber);
            validateNumbersDoesntHasBonus(numbers, bonusNumber);
        }

        static void validateSize(int numberOfValue){
            if(numberOfValue != Lotto.NUMBER_OF_WRITE_NUMBER){
                throw new IllegalArgumentException(
                        "당첨번호의 갯수는 ".concat(String.valueOf(Lotto.NUMBER_OF_WRITE_NUMBER)).concat("개 입력해주세요."));
            }
        }

        static void validateOneNumber(Integer number) throws IllegalArgumentException{
            if(number <= 0 || number > 45){
                throw new IllegalArgumentException("당첨번호는 1이상 45 이하입니다.");
            }
        }

        static void validateNumbersDoesntHasBonus(List<Integer> numbers, int bonusNumber){
            if(numbers.contains(bonusNumber)){
                throw new IllegalArgumentException("보너스 숫자는 당첨번호들과 달라야 합니다.");
            }
        }
    }
}
