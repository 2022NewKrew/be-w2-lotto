package carrot.ez.lotto;

public enum WiningInfo {
    Fourth(3, 5000),
    Third(4, 50000),
    Second(5, 1500000),
    First(6, 2000000000);

    private final int correctNum;
    private final long price;
    WiningInfo(int correctNum, long price) {
        this.correctNum = correctNum;
        this.price = price;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public long getPrice() {
        return price;
    }
}