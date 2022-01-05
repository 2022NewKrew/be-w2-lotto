package domain;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private static final Integer LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    private void validateSize(List<LottoNumber> lottoNumbers){
        if(lottoNumbers.size() != LOTTO_NUMBER_SIZE) throw new IllegalArgumentException();
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers){
        int count = (int) lottoNumbers.stream()
                .distinct()
                .count();

        if(count!= LOTTO_NUMBER_SIZE) throw new IllegalArgumentException();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
