package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class LottoDto {

    private final List<Integer> lottoNumber;

    public LottoDto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoDto lottoToDto(Lotto lotto) {
        return new LottoDto(lotto.getLottoNumber());
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
