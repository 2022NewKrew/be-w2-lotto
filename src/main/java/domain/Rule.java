package domain;

public class Rule {
    private final int lotteryNumberStart;
    private final int lotteryNumberEnd;
    private final int lotteryNumberCount;
    private final int lotteryUnitPrice;

    private Rule(int lotteryNumberStart, int lotteryNumberEnd, int lotteryNumberCount, int lotteryUnitPrice) {
        this.lotteryNumberStart = lotteryNumberStart;
        this.lotteryNumberEnd = lotteryNumberEnd;
        this.lotteryNumberCount = lotteryNumberCount;
        this.lotteryUnitPrice = lotteryUnitPrice;
    }

    public int getLotteryNumberStart() {
        return lotteryNumberStart;
    }

    public int getLotteryNumberEnd() {
        return lotteryNumberEnd;
    }

    public int getLotteryNumberCount() {
        return lotteryNumberCount;
    }

    public int getLotteryUnitPrice() {
        return lotteryUnitPrice;
    }

    public static class Builder {
        private int lotteryNumberStart;
        private int lotteryNumberEnd;
        private int lotteryNumberCount;
        private int lotteryUnitPrice;

        public Builder lotteryNumberStart(int lotteryNumberStart) {
            this.lotteryNumberStart = lotteryNumberStart;
            return this;
        }

        public Builder lotteryNumberEnd(int lotteryNumberEnd) {
            this.lotteryNumberEnd = lotteryNumberEnd;
            return this;
        }

        public Builder lotteryNumberCount(int lotteryNumberCount) {
            this.lotteryNumberCount = lotteryNumberCount;
            return this;
        }

        public Builder lotteryUnitPrice(int lotteryUnitPrice) {
            this.lotteryUnitPrice = lotteryUnitPrice;
            return this;
        }

        public Rule build() {
            return new Rule(lotteryNumberStart, lotteryNumberEnd, lotteryNumberCount, lotteryUnitPrice);
        }
    }
}
