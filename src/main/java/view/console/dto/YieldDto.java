package view.console.dto;


public class YieldDto {

    private final long earnedMoney;
    private final long price;

    public YieldDto(long earnedMoney, long price) {
        this.earnedMoney = earnedMoney;
        this.price = price;
    }

    public long getEarnedMoney() {
        return earnedMoney;
    }

    public long getPrice() {
        return price;
    }
}
