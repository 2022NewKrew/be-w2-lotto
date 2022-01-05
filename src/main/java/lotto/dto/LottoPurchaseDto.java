package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoPurchaseDto {
    private final int purchaseAmount;
    private final int purchaseGameCnt;
    private final List<LottoGameDto> lottoGames;

    public LottoPurchaseDto(int purchaseAmount, int purchaseGameCnt, List<LottoGameDto> lottoGames) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseGameCnt = purchaseGameCnt;
        this.lottoGames = lottoGames;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseGameCnt() {
        return purchaseGameCnt;
    }

    public List<LottoGameDto> getLottoGames() {
        return Collections.unmodifiableList(lottoGames);
    }
}
