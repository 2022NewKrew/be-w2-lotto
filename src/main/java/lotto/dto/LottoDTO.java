package lotto.dto;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoDTO {

    private final List<Integer> lottoNumbers;

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto.getLottoNumbers());
    }

    private LottoDTO(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
