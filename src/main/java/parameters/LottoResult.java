package parameters;

import constants.RankInfo;

import java.util.HashMap;

public class LottoResult {
    private final HashMap<RankInfo, Integer> results;

    public LottoResult() {
        results = new HashMap<>();
        initiate();
    }

    private void initiate() {
        RankInfo.valuesStream()
                .forEach(this::addResult);
        addResult(RankInfo.FAIL);
    }

    private void addResult(RankInfo rankInfo) {
        results.put(rankInfo, 0);
    }

    public void addCountToResult(RankInfo rankInfo) {
        results.put(rankInfo, getResult(rankInfo) + 1);
    }

    public int getResult(RankInfo rankInfo) {
        return results.get(rankInfo);
    }

}
