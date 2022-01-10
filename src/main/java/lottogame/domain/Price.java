package lottogame.domain;

import lottogame.exception.ErrorMessage;
import lottogame.exception.LotteryGameException;

public class Price {
    private static final int MIN_PRICE = 1;
    private int price;

    public Price(int price) {
        validateUpperMinPrice(price);
        this.price = price;
    }

    private void validateUpperMinPrice(int price) {
        if (price < MIN_PRICE) {
            throw new LotteryGameException(ErrorMessage.UNDER_MIN_PRICE);
        }
    }

    public int calculateAmount(Price defaultPrice) {
        if(this.price % defaultPrice.price != 0)
            throw new LotteryGameException(ErrorMessage.INSUFFICIENT_PRICE);
        return (int) this.price / defaultPrice.price;
    }
}