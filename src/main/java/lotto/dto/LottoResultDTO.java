package lotto.dto;

import java.util.List;

public class LottoResultDTO {

    private List<String> message;
    private double totalRateOfReturn;

    public LottoResultDTO(List<String> message, double totalRateOfReturn) {
        this.message = message;
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public void setTotalRateOfReturn(double totalRateOfReturn) {
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public List<String> getMessage() {
        return message;
    }

    public double getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
