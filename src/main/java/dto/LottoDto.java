package dto;

import domain.Lotto;


public class LottoDto {

    private final long earnedMoney;
    private final long price;

    public LottoDto(Lotto lotto) {
        this.earnedMoney = lotto.getEarnedMoney();
        this.price = lotto.getPrice();
    }

    public long getEarnedMoney() {
        return earnedMoney;
    }

    public long getPrice() {
        return price;
    }
}
