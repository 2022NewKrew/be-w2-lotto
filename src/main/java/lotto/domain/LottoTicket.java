package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private static final Integer LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList;
    private LottoWinningResult lottoWinningResult;

    public LottoTicket(Integer purchaseAmount) {
        this.lottoList = makeLotto(calculateLottoCount(purchaseAmount));
    }

    private List<Lotto> makeLotto(Integer lottoCount) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto());
        }

        return lotto;
    }

    private Integer calculateLottoCount(Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public Integer getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Integer getWholeLottoPrice() {
        return LOTTO_PRICE * getLottoCount();
    }

    public void calculateLottoWinningResult(List<Integer> winningNumbers) {
        lottoWinningResult = new LottoWinningResult(winningNumbers, lottoList);
    }

    public LottoWinningResult getLottoWinningResult() {
        return lottoWinningResult;
    }
}
