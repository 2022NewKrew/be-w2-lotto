package lottogame.domain;

import java.util.List;

public class LotteryNumbers {
    private static final int DEFAULT_SIZE = 6;
    private static final String START_STRING = "[";
    private static final String END_STRING = "]";
    private static final String DELIMITER = ", ";

    private List<LotteryNumber> numbers;

    LotteryNumbers(List<LotteryNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<LotteryNumber> numbers) {
        if (numbers.size() != DEFAULT_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리만 가능 합니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringNumbers = new StringBuilder();
        for (var number : numbers) {
            String delimiter = setDelimiter(stringNumbers);
            stringNumbers.append(delimiter);
            stringNumbers.append(number.toString());
        }
        stringNumbers.append(END_STRING);
        return stringNumbers.toString();
    }

    private String setDelimiter(StringBuilder stringNumbers) {
        if (stringNumbers.length() == 0) {
            return START_STRING;
        }
        return DELIMITER;
    }

    public List<LotteryNumber> getNumbers() {
        return numbers;
    }

    public int countOfSameNumbers(LotteryNumbers compareNumbers) {
        List<LotteryNumber> compare = compareNumbers.getNumbers();
        int count = 0;
        for (var number : numbers) {
            count += compareNumber(compare, number);
        }
        return count;
    }

    public int compareNumber(List<LotteryNumber> compare, LotteryNumber number) {
        if (compare.contains(number)) {
            return 1;
        }
        return 0;
    }
}
