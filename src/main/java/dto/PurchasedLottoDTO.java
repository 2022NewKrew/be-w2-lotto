package dto;

import domain.OneLotto;

import java.util.List;

public class PurchasedLottoDTO {

    private int purchaseAmount;
    private List<OneLotto> totalLotto;
    private int lottoCount;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void setTotalLotto(List<OneLotto> totalLotto) {
        this.totalLotto = totalLotto;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<OneLotto> getTotalLotto() {
        return totalLotto;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
