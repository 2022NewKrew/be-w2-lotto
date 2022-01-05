package lotto.domain.winningstats.winningprice;

public enum WinningPrice {

    THREE(3, 5000, "3개 일치"), FOUR(4, 50000, "4개 일치"),
    FIVE(5, 1500000, "5개 일치"), FIVE_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치"), SIX(6, 2000000000, "6개 일치");

    private final int correctCount;
    private final long price;
    private final String printSentence;
    private int lottoCount;

    WinningPrice(int correctCount, long price, String printSentence) {
        this.correctCount = correctCount;
        this.price = price;
        this.printSentence = printSentence;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long calculateProfit() {
        return lottoCount * price;
    }

    public void addCount() {
        lottoCount += 1;
    }

    public String printWinningPrice() {
        return printSentence +
                "(" +
                price +
                "원)- " +
                lottoCount +
                "개\n";
    }
}
