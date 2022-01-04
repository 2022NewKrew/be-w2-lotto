package domain;

import exception.LottoAmountLimitException;

import java.util.List;
import java.util.Map;

public class LottoResult {
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private List<Integer> numbers;
    private Map<Integer, Integer> countOfMatches;
    private double profitRate;

    public LottoResult(List<Integer> numbers) {
        validateLottoAmount(numbers);
        validateLottoNumberRange(numbers);
        this.numbers = numbers;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public void setCountOfMatches(Map<Integer, Integer> countOfMatches) {
        this.countOfMatches = countOfMatches;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Map<Integer, Integer> getCountOfMatches() {
        return countOfMatches;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void validateLottoAmount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoAmountLimitException("로또 번호는 6개입니다.");
        }
    }

    public void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number.intValue() < LOTTO_NUMBER_MIN || number.intValue() > LOTTO_NUMBER_MAX) {
                throw new LottoAmountLimitException("로또 번호의 범위는 1~45 입니다.");
            }
        }
    }
}
