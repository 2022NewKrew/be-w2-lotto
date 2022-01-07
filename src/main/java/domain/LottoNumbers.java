package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Constants.LOTTO_NUMBER_SIZE;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.numbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) throw new IllegalArgumentException();
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        int count = (int) lottoNumbers.stream()
                .distinct()
                .count();

        if (count != LOTTO_NUMBER_SIZE) throw new IllegalArgumentException();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
