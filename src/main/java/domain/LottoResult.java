package domain;

import java.util.List;

public class LottoResult {

    private static final int FIRST_PRIZE = 6;
    private static final int SECOND_PRIZE = 5;
    private static final int THIRD_PRIZE = 4;
    private static final int FOURTH_PRIZE = 3;

    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int totalEarning;
    private final double earningRatio;

    public LottoResult(List<Integer> matchedList, int inputMoney) {
        for (Integer matchedNum : matchedList) {
            updatePrizeCount(matchedNum);
        }
        earningRatio = (totalEarning / (double) inputMoney) * 100;
    }

    private void updatePrizeCount(int matchedNum) {
        switch (matchedNum) {
            case FIRST_PRIZE:
                firstPrizeCount++;
                totalEarning += 2000000000;
                break;
            case SECOND_PRIZE:
                secondPrizeCount++;
                totalEarning += 1500000;
                break;
            case THIRD_PRIZE:
                thirdPrizeCount++;
                totalEarning += 50000;
                break;
            case FOURTH_PRIZE:
                fourthPrizeCount++;
                totalEarning += 5000;
        }
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

    public double getEarningRatio() {
        return earningRatio;
    }
}
