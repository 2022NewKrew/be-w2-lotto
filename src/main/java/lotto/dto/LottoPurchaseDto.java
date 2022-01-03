package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchaseDto {
    private final int purchaseGameCnt;
    private final List<LottoGameDto> lottoGames = new ArrayList<>();

    public LottoPurchaseDto(int purchaseGameCnt) {
        this.purchaseGameCnt = purchaseGameCnt;
    }

    public int getPurchaseGameCnt() {
        return purchaseGameCnt;
    }

    public List<LottoGameDto> getLottoGames() {
        return Collections.unmodifiableList(lottoGames);
    }
}
