package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbersFactory {
    private static final int NUMBER_DOMAIN_START = 1;
    private static final int NUMBER_DOMAIN_END = 45;
    private static final List<Integer> NUMBERS_DOMAIN = IntStream.rangeClosed(NUMBER_DOMAIN_START, NUMBER_DOMAIN_END).boxed().collect(Collectors.toList());
    private static final int NUMBERS_LENGTH = 6;

    public List<Integer> getRandomNumbers() {
        Collections.shuffle(NUMBERS_DOMAIN);
        List<Integer> numbers = new ArrayList<>(NUMBERS_DOMAIN.subList(0, NUMBERS_LENGTH));
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getValidatedNumbers(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateNumbersNonRedundancy(numbers);
        List<Integer> validatedNumbers = new ArrayList<>();
        for (var number : numbers) {
            validateNumberDomain(number);
            validatedNumbers.add(number);
        }
        Collections.sort(validatedNumbers);
        return validatedNumbers;
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException("로또 번호 " + numbers + "는 " + NUMBERS_LENGTH + "자리가 아닙니다.");
        }
    }

    private void validateNumbersNonRedundancy(List<Integer> numbers) {
        if (!numbers.stream().sequential().allMatch(new HashSet<>()::add)) {
            throw new IllegalArgumentException("로또 번호 " + numbers + "에 중복이 있습니다.");
        }
    }

    private void validateNumberDomain(int number) {
        if (!NUMBERS_DOMAIN.contains(number)) {
            throw new IllegalArgumentException("숫자 " + number + " 는 로또 번호 범위(" + NUMBER_DOMAIN_START + "~" + NUMBER_DOMAIN_END + ") 밖입니다.");
        }
    }
}
