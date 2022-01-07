package be.w2.lotto.View;

import java.util.ArrayList;
import java.util.List;

public class WebLottoResult {
    List<String> message;
    long totalRateOfReturn;

    public WebLottoResult(List<List<String>> statistics, long earningRate){
        message = new ArrayList<>();
        for(List<String> statistic : statistics){
            String webString = String.format("%s - %s 개", statistic.get(0), statistic.get(1));
            message.add(webString);
        }
        totalRateOfReturn = earningRate;
    }

    public List<String> getMessage(){
        return message;
    }

    public long getTotalRateOfReturn(){
        return totalRateOfReturn;
    }

}
