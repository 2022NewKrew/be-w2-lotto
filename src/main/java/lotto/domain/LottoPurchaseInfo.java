package lotto.domain;

public class LottoPurchaseInfo {
    private static final int LOTTO_PRICE = 1000;

    private final int money;
    private final int countOfPurchaseLotto;

    public LottoPurchaseInfo(int money) {
        this(money, money / LOTTO_PRICE);
    }

    public LottoPurchaseInfo(int money, int countOfPurchaseLotto) {
        this.countOfPurchaseLotto = countOfPurchaseLotto;
        checkCanBuyLotto(countOfPurchaseLotto);
        this.money = money;
    }

    private void checkCanBuyLotto(int countOfPurchaseLotto) {
        if(countOfPurchaseLotto <= 0){
            throw new IllegalArgumentException("구입 금액이 부족합니다.");
        }
    }


    public int getMoney() {
        return money;
    }

    public int getCountOfPurchaseLotto() {
        return countOfPurchaseLotto;
    }

}
