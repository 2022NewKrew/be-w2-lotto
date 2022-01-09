package lotto.request;

import lotto.configure.LottoConfigure;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PurchaseRequest {

    private int money;

    private List<List<Integer>> requestManulLottos;

    public PurchaseRequest(int money, @NotNull List<List<Integer>> requestManulLottos) {
        if (money <= 0) throw new IllegalArgumentException();
        this.money = money;
        if (requestManulLottos.size() * LottoConfigure.LOTTO_PRICE <= money ) throw new IllegalArgumentException();
        this.requestManulLottos = requestManulLottos;
    }

    public int getMoney() {
        return money;
    }

    public List<List<Integer>> getRequestManulLottos() {
        return requestManulLottos;
    }


    public int purchasableLottoCount() {
        return money / LottoConfigure.LOTTO_PRICE - requestManulLottos.size();
    }
}
