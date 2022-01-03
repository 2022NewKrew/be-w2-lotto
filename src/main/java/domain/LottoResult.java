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

    public LottoResult(List<Integer> matchedList) {
        for (Integer matchedNum : matchedList) {
            updatePrizeCount(matchedNum);
        }
    }

    private void updatePrizeCount(int matchedNum) {
        switch (matchedNum) {
            case FIRST_PRIZE:
                firstPrizeCount++;
                break;
            case SECOND_PRIZE:
                secondPrizeCount++;
                break;
            case THIRD_PRIZE:
                thirdPrizeCount++;
                break;
            case FOURTH_PRIZE:
                fourthPrizeCount++;
        }
    }

    public List<Integer> getLottoResultList() {
        return List.of(
                firstPrizeCount,
                secondPrizeCount,
                thirdPrizeCount,
                fourthPrizeCount
        );
    }

}
