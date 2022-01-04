package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList;

    public LottoTicket(int purchaseAmount) {
        this.lottoList = Collections.unmodifiableList(makeLotto(calculateLottoCount(purchaseAmount)));
    }

    private List<Lotto> makeLotto(int lottoCount) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new Lotto());
        }

        return lotto;
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getWholeLottoPrice() {
        return LOTTO_PRICE * getLottoCount();
    }

    public LottoWinningResult getLottoWinningResult(List<Integer> winningNumbers, int bonusBallNumber) {
        return new LottoWinningResult(winningNumbers, bonusBallNumber, lottoList);
    }

}
