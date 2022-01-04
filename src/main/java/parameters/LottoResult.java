package parameters;

import constants.LottoRule;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
    private final HashMap<RankInfo, Result> results;

    public LottoResult() {
        results = new HashMap<>();
        initiate();
    }

    private void initiate(){
        addResult(new RankInfo(LottoRule.FIRST, false), new Result(2000000000));
        addResult(new RankInfo(LottoRule.SECOND, true), new Result(30000000));
        addResult(new RankInfo(LottoRule.THIRD, false), new Result(1500000));
        addResult(new RankInfo(LottoRule.FOURTH, false), new Result(50000));
        addResult(new RankInfo(LottoRule.FIFTH, false), new Result(5000));
        addResult(new RankInfo(LottoRule.FAIL, false), new Result(0));
        addResult(new RankInfo(LottoRule.FAIL, true), new Result(0));
    }

    public void addResult(RankInfo rankInfo, Result result) { results.put(rankInfo, result); }
    public void addCountToResult(RankInfo rankInfo) {
        results.get(rankInfo).addCount();
    }
    public Result getResult(RankInfo rankInfo) { return results.get(rankInfo); }

    public String getViewFormat(RankInfo rankInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(rankInfo.getCount());
        sb.append("개 일치");
        if(rankInfo.getBonus()) sb.append(", 보너스 볼 일치");
        sb.append("(");
        sb.append(results.get(rankInfo).getReward());
        sb.append(")- ");
        sb.append(results.get(rankInfo).getCount());
        sb.append("개");
        return sb.toString();
    }
}
