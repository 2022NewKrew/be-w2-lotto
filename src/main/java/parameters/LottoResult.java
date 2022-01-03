package parameters;

import constants.LottoRule;

import java.util.HashMap;

public class LottoResult {
    private final HashMap<Integer, Result> results;

    public LottoResult() {
        results = new HashMap<>();
        initiate();
    }

    private void initiate(){
        addResult(LottoRule.FIRST, new Result(2000000000));
        addResult(LottoRule.SECOND, new Result(1500000));
        addResult(LottoRule.THIRD, new Result(50000));
        addResult(LottoRule.FOURTH, new Result(5000));
        addResult(LottoRule.FAIL, new Result(0));
    }

    public void addResult(int idx, Result result) { results.put(idx, result); }
    public void addCountToResult(int idx) { results.get(idx).addCount(); }
    public Result getResult(int idx) { return results.get(idx); }

    public String getViewFormat(int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(idx);
        sb.append("개 일치 (");
        sb.append(results.get(idx).getReward());
        sb.append(")- ");
        sb.append(results.get(idx).getCount());
        sb.append("개");
        return sb.toString();
    }
}
