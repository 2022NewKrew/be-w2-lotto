package lottogame.domain;

public class RateOfReturn {
    private int rateOfReturn;

    private RateOfReturn(int rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public static RateOfReturn calculate(int prizeMoney, int purchasedPrice) {
        int rate = (int) (((double) (prizeMoney / purchasedPrice)) * 100 - 100);
        return new RateOfReturn(rate);
    }

    public int getRateOfReturn() {
        return rateOfReturn;
    }
}
