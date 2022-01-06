package step4.dto;

import java.util.List;

public class LottoResultViewDto {
    private List<String> message;
    private Double totalRateOfReturn;

    public LottoResultViewDto(List<String> message, Double totalRateOfReturn) {
        this.message = message;
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public List<String> getMessage() {
        return message;
    }

    public Double getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
