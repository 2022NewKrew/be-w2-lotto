package lotto.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private static final String INVALID_NUMBERS_ERROR_MESSAGE = "로또 번호가 중복되거나 6개가 아닙니다.";

    private final List<LottoNumber> lottoNumbers;

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (!isValidLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(INVALID_NUMBERS_ERROR_MESSAGE);
        }
        this.lottoNumbers = lottoNumbers;
    }

    private boolean isValidLottoNumbers(List<LottoNumber> lottoNumbers) {
        return validateLottoNumbersSize(lottoNumbers) && validateLottoNumbersDuplicate(
            lottoNumbers);
    }

    private boolean validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == LOTTO_NUMBERS_SIZE;
    }

    private boolean validateLottoNumbersDuplicate(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == lottoNumbers.stream().map(LottoNumber::getNumber).distinct()
            .count();
    }

    public boolean hasNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public int calculateMatchCountWith(Lotto ticket) {
        return (int) lottoNumbers.stream()
            .filter(ticket::hasNumber)
            .count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
