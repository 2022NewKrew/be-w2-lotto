package dto.response;

import model.Lotto;

public class CheckedLottoDTO {
    private final String lottoResult;

    private CheckedLottoDTO(String lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static CheckedLottoDTO of(Lotto lotto) {
        return new CheckedLottoDTO(lotto.convertResultToString());
    }

    public String getLottoResult() {
        return lottoResult;
    }
}
