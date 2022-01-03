package domain;

public class Result {
    private final Prize prize;
    private final int count;

    Result(Prize prize, int count) {
        this.prize = prize;
        this.count = count;
    }

    public Prize getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public int getPrizeMoney() {
        return prize.getMoney() * count;
    }
}
