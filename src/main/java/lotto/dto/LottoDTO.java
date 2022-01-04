package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoDTO {

    private final List<Integer> lottoNumbers;

    public LottoDTO(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
