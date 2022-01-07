package dto;

import java.util.List;

public class LottoResultResponse {

    private final List<String> message;
    private final String totalRateOfReturn;

    public LottoResultResponse(List<String> message, String totalRateOfReturn) {
        this.message = message;
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public List<String> getMessage() {
        return message;
    }

    public String getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
