package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final Integer LOTTO_PRICE = 1000;
    private final List<LottoRow> lottoRows;
    private LottoWinningResult lottoWinningResult;

    public Lotto(Integer purchaseAmount) {
        this.lottoRows = makeLottoRows(calculateLottoCount(purchaseAmount));
    }

    private List<LottoRow> makeLottoRows(Integer lottoCount) {
        List<LottoRow> lottoRows = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoRows.add(new LottoRow());
        }

        return lottoRows;
    }

    private Integer calculateLottoCount(Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public Integer getLottoCount() {
        return lottoRows.size();
    }

    public List<LottoRow> getLottoRows() {
        return lottoRows;
    }

    public Integer getWholeLottoPrice() {
        return LOTTO_PRICE * getLottoCount();
    }

    public void calculateLottoWinningResult(List<Integer> winningNumbers) {
        lottoWinningResult = new LottoWinningResult(winningNumbers, lottoRows);
    }

    public LottoWinningResult getLottoWinningResult() {
        return lottoWinningResult;
    }
}
