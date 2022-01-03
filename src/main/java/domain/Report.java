package domain;

public class Report {
    final int investment, prizeSum;
    final int firstPrizeValue, secondPrizeValue, thirdPrizeValue, fourthPrizeValue;
    final int firstPrizeCount;
    final int secondPrizeCount;
    final int thirdPrizeCount;
    final int fourthPrizeCount;

    public Report(int investment, int firstPrizeValue, int secondPrizeValue, int thirdPrizeValue, int fourthPrizeValue, int firstPrizeCount, int secondPrizeCount, int thirdPrizeCount, int fourthPrizeCount) {
        this.investment = investment;
        prizeSum = firstPrizeValue * firstPrizeCount + secondPrizeValue * secondPrizeCount + thirdPrizeValue * thirdPrizeCount + fourthPrizeValue * fourthPrizeCount;
        this.firstPrizeValue = firstPrizeValue;
        this.secondPrizeValue = secondPrizeValue;
        this.thirdPrizeValue = thirdPrizeValue;
        this.fourthPrizeValue = fourthPrizeValue;
        this.firstPrizeCount = firstPrizeCount;
        this.secondPrizeCount = secondPrizeCount;
        this.thirdPrizeCount = thirdPrizeCount;
        this.fourthPrizeCount = fourthPrizeCount;
    }

    public int getFirstPrizeValue() {
        return firstPrizeValue;
    }

    public int getSecondPrizeValue() {
        return secondPrizeValue;
    }

    public int getThirdPrizeValue() {
        return thirdPrizeValue;
    }

    public int getFourthPrizeValue() {
        return fourthPrizeValue;
    }

    public int getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public int getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public int getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public int getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public int getProfitRateAsPercentage() {
        // Generally speaking, it's not the "profit rate" we'd expect in daily use.
        return 100 * prizeSum / investment;
    }
}
