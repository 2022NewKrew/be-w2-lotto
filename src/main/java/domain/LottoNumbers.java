package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final Integer LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.numbers = createLottoNumbers(lottoNumbers);
    }

    private void validateSize(List<Integer> lottoNumbers){
        if(lottoNumbers.size() != LOTTO_NUMBER_SIZE) throw new IllegalArgumentException();
    }

    private void validateDuplicate(List<Integer> lottoNumbers){
        int count = (int) lottoNumbers.stream()
                .distinct()
                .count();

        if(count!= LOTTO_NUMBER_SIZE) throw new IllegalArgumentException();
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> lottoNumbers){
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
