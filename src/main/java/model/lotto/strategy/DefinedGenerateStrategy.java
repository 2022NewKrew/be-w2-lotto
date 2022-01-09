package model.lotto.strategy;

import model.lotto.Lotto;
import model.lotto.number.LottoNumber;
import utility.NullChecker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefinedGenerateStrategy implements GenerateLottoStrategy {

    List<LottoNumber> numbers;

    public DefinedGenerateStrategy(List<Integer> numbers) {
        checkNumbers(numbers);

        this.numbers = integersToNumbers(numbers);
    }

    public List<LottoNumber> generate() {
        return numbers;
    }

    private void checkNumbers(List<Integer> lottoNumbers) {
        checkNull(lottoNumbers);
        checkNumbersLength(lottoNumbers);
        checkDuplicateNumber(lottoNumbers);
    }

    private void checkNull(List<Integer> lottoNumbers) {
        NullChecker.checkNotNull(lottoNumbers);
    }

    private void checkNumbersLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.LENGTH_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 부적절합니다!");
        }
    }

    private void checkDuplicateNumber(List<Integer> lottoNumbers) {
        Set<Integer> testSet = new HashSet<>(lottoNumbers);
        if (testSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    private List<LottoNumber> integersToNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::valueOf).collect(Collectors.toUnmodifiableList());
    }
}
