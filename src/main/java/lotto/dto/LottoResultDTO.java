package lotto.dto;

import lotto.domain.game.LottoGameResult;

public class LottoResultDTO {

    private final LottoRankCountDTO lottoRankCountDTO;
    private final LottoProfitRateDTO lottoProfitRateDTO;

    public static LottoResultDTO from(LottoGameResult lottoGameResult) {
        return new LottoResultDTO(LottoRankCountDTO.from(lottoGameResult.getLottoRankCount()),
            LottoProfitRateDTO.from(lottoGameResult.getLottoProfitRate()));
    }

    private LottoResultDTO(LottoRankCountDTO lottoRankCountDTO,
        LottoProfitRateDTO lottoProfitRateDTO) {
        this.lottoRankCountDTO = lottoRankCountDTO;
        this.lottoProfitRateDTO = lottoProfitRateDTO;
    }

    public LottoRankCountDTO getLottoRankCountDTO() {
        return lottoRankCountDTO;
    }

    public LottoProfitRateDTO getLottoProfitRateDTO() {
        return lottoProfitRateDTO;
    }
}
