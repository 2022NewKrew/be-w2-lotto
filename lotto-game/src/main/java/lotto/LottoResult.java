package lotto;

import java.util.HashMap;

public class LottoResult {
    private HashMap<LottoGrade, Integer> resultCounterMap;

    public LottoResult(){
        resultCounterMap = new HashMap<>();

    }

    public void addResult(LottoGrade grade){
        resultCounterMap.put(grade, resultCounterMap.getOrDefault(grade,0) + 1);
    }

    public int calculateProceed(){
        int result = 0;
        for(LottoGrade grade : LottoGrade.values()){
            result += resultCounterMap.getOrDefault(grade,0) * grade.getReward();
        }
        return result;
    }

    public int getResult(LottoGrade grade){
        return resultCounterMap.getOrDefault(grade, 0);
    }
}
