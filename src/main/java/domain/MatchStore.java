package domain;

import java.util.HashMap;
import java.util.Map;

public class MatchStore {
    private final Map<WinningClassifier, Integer> matchDict = new HashMap<>();

    private static final Long PRICE_PER_LOTTO = 1000L;

    public MatchStore() {
        for (WinningClassifier grade : WinningClassifier.values()) {
            matchDict.put(grade, 0);
        }
    }

    public void addMatchResult(int matchCnt, int bonusCnt) {
        WinningClassifier grade = WinningClassifier.findMatchScoreObject(matchCnt, bonusCnt);

        matchDict.put(grade, matchDict.get(grade) + 1);
    }

    public int getCnt(WinningClassifier grade) {
        return matchDict.get(grade);
    }

    public float getYield() {
        if (getNumLotto() == 0) {
            return 0.0F;
        }

        return getTotalWinPrice() / (float) (getNumLotto() * PRICE_PER_LOTTO) * 100 - 100;

    }

    private long getTotalWinPrice() {
        long totalWinPrice = 0L;

        for (WinningClassifier grade : matchDict.keySet()) {
            totalWinPrice += grade.getPrice() * matchDict.get(grade);
        }

        return totalWinPrice;
    }

    private int getNumLotto() {
        int numLotto = 0;

        for (int cnt : matchDict.values()) {
            numLotto += cnt;
        }

        return numLotto;
    }
}
