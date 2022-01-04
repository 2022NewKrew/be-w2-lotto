package lottoStage2.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {

    private final Map<WinningType, Integer> winningResult = new LinkedHashMap<>();

    private WinningResult() {
        for(WinningType type : WinningType.values()) {
            winningResult.put(type, 0);
        }
    }

    public static WinningResult create() {
        return new WinningResult();
    }

    public void addCount(WinningType type) {
        int matchCount = winningResult.get(type);
        winningResult.put(type, matchCount + 1);
    }

    public Map<WinningType, Integer> getWinningResult() {
        return winningResult;
    }

    public int totalWinnings() {
        int totalWinnings = 0;
        for(WinningType type : winningResult.keySet()) {
            totalWinnings += (type.getWinnings() * winningResult.get(type));
        }

        return totalWinnings;
    }
}
