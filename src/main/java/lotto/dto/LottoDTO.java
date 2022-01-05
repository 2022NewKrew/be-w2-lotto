package lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.model.Lotto;

public class LottoDTO {

    private final List<LottoNumberDTO> lottoNumbers;

    public static LottoDTO from(Lotto lotto) {
        return new LottoDTO(lotto.getLottoNumbers().stream().map(LottoNumberDTO::from)
            .collect(Collectors.toList()));
    }

    private LottoDTO(List<LottoNumberDTO> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumberDTO> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
