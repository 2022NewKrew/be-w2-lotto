package domain;

import java.util.*;

public class WinningNumbers {
    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        Validator.validate(numbers, bonusNumber);

        this.numbers = new TreeSet<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public RewardType matching(List<Integer> numbers){
        int matched = numbers.stream()
                .map(this.numbers::contains)
                .mapToInt(contained -> contained ? 1 : 0)
                .reduce(Integer::sum).orElse(0);
        boolean isBonusMatched = numbers.contains(bonusNumber);

        return RewardType.of(matched, isBonusMatched);
    }

    private static class Validator{
        static void validate(List<Integer> numbers, int bonusNumber) {
            validateNumbers(numbers);
            validateBonusNumber(numbers, bonusNumber);
        }

        static void validateNumbers(List<Integer> numbers){
            validateSize(numbers.size());
            validateDuplicate(numbers);
            for(Integer number : numbers){
                validateNumber(number);
            }
        }

        static void validateDuplicate(List<Integer> numbers){
            if(numbers.stream().distinct().count() != numbers.size()){
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
        }

        static void validateSize(int numberOfValue){
            if(numberOfValue != Lotto.NUMBER_OF_WRITE_NUMBER){
                throw new IllegalArgumentException(
                        "당첨번호의 갯수는 ".concat(String.valueOf(Lotto.NUMBER_OF_WRITE_NUMBER)).concat("개 입력해주세요."));
            }
        }

        static void validateNumber(Integer number) throws IllegalArgumentException{
            if(number < LottoNumber.MIN_NUMBER || number > LottoNumber.MAX_NUMBER){
                throw new IllegalArgumentException("당첨번호는 ".concat(String.valueOf(LottoNumber.MIN_NUMBER))
                        .concat("이상 ").concat(String.valueOf(LottoNumber.MAX_NUMBER)).concat("이하입니다."));
            }
        }

        static void validateBonusNumber(List<Integer> numbers, int bonusNumber){
            validateNumber(bonusNumber);
            validateBonusNumberNotContained(numbers, bonusNumber);
        }

        static void validateBonusNumberNotContained(List<Integer> numbers, int bonusNumber){
            if(numbers.contains(bonusNumber)){
                throw new IllegalArgumentException("보너스 숫자는 당첨번호들과 달라야 합니다.");
            }
        }
    }
}
