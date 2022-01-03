package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(List<LottoNumber> lottoNumbers) {
        if (!isValidLength(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (isDuplicated(lottoNumbers)) {
            throw new IllegalArgumentException("로또 번호에는 중복이 없어야 합니다.");
        }
        return new LottoTicket(lottoNumbers);
    }

    private static boolean isValidLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            return false;
        }
        return true;
    }

    private static boolean isDuplicated(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumbers.size() != lottoNumberSet.size()) {
            return true;
        }
        return false;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
