package lottogame.domain;

public class RateOfReturn {
    private int rate;

    RateOfReturn(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return String.format("총 수익률은 %d%%입니다.", rate);
    }
}
