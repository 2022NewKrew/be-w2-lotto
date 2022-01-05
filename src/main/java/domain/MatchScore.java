package domain;

import java.util.ArrayList;
import java.util.List;

public enum MatchScore {
    FIFTH(5_000L, 3, -1), FORTH(50_000L, 4, -1), THIRD(1_500_000L, 5, 0), SECOND(30_000_000L, 5, 1), FIRST(2_000_000_000L, 6, 0), BOMB(0L, 0, -1);

    private final long price;
    private final int matchNums;
    //matchingBonus 의 -1은 보너스가 몇개 맞았던 상관하지 않음을 의미
    private final int matchBonus;
    private int numLotto;

    private MatchScore(long price, int matchNums, int matchBonus) {
        this.price = price;
        this.matchNums = matchNums;
        this.matchBonus = matchBonus;
        this.numLotto = 0;
    }

    public long getPrice() {
        return price;
    }

    public int getMatchNums() {
        return matchNums;
    }

    public boolean isMatchBonus() {
        return matchBonus > 0;
    }

    public void addNumLotto() {
        numLotto += 1;
    }

    public int getNumLotto() {
        return numLotto;
    }

    public static MatchScore findMatchScoreObject(int matchNum, int matchBonus) {
        MatchScore[] mss = values();
        for (MatchScore ms : mss) {
            if (ms.matchBonus == -1 && ms.matchNums == matchNum) {
                return ms;
            }
            if (ms.matchNums == matchNum && ms.matchBonus == matchBonus) {
                return ms;
            }
        }

        return BOMB;
    }

    public static List<MatchScore> getWinObjLst() {
        List<MatchScore> ret = new ArrayList<>(List.of(values()));
        ret.remove(BOMB);

        return ret;
    }

    public static Long getTotalPrice() {
        MatchScore[] mss = values();
        long totalPrice = 0L;

        for (MatchScore ms : mss) {
            totalPrice += ms.price * ms.numLotto;
        }

        return totalPrice;
    }

    public static void initForTest() {
        MatchScore[] mss = values();

        for (MatchScore ms : mss) {
            ms.numLotto = 0;
        }
    }
}
