package domain;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_OF_WRITE_NUMBER = 6;

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        lottoNumbers = new LottoNumbers(numbers);
    }

    void validate(List<Integer> numbers) {
        LottoNumbers.validate(numbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
