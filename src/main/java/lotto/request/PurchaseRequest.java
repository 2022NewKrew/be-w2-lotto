package lotto.request;

import lotto.configure.LottoConfigure;

import java.util.List;

public class PurchaseRequest {

    private int money;

    private List<String> requestManulLottos;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<String> getRequestManulLottos() {
        return requestManulLottos;
    }

    public void setRequestManulLottos(List<String> requestManulLottos) {
        this.requestManulLottos = requestManulLottos;
    }

    public int purchasableLottoCount() {
        return money / LottoConfigure.LOTTO_PRICE;
    }
}
