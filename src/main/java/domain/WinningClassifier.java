package domain;

import java.util.ArrayList;
import java.util.List;

public enum WinningClassifier {
    FIFTH(5_000L, 3, -1), FORTH(50_000L, 4, -1), THIRD(1_500_000L, 5, 0), SECOND(30_000_000L, 5, 1), FIRST(2_000_000_000L, 6, 0), BOMB(0L, 0, -1);

    private final long price;
    private final int matchNums;
    //matchingBonus 의 -1은 보너스가 몇개 맞았던 상관하지 않음을 의미
    private final int matchBonus;

    private WinningClassifier(long price, int matchNums, int matchBonus) {
        this.price = price;
        this.matchNums = matchNums;
        this.matchBonus = matchBonus;
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

    public static WinningClassifier findMatchScoreObject(int matchNum, int matchBonus) {
        WinningClassifier[] mss = values();
        for (WinningClassifier ms : mss) {
            if (ms.matchBonus == -1 && ms.matchNums == matchNum) {
                return ms;
            }
            if (ms.matchNums == matchNum && ms.matchBonus == matchBonus) {
                return ms;
            }
        }

        return BOMB;
    }

    public static List<WinningClassifier> getWinObjLst() {
        List<WinningClassifier> ret = new ArrayList<>(List.of(values()));
        ret.remove(BOMB);

        return ret;
    }
}
