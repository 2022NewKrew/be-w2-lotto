package carrot.ez.dto.response;

import java.util.List;

public class LottosResultDto {
    private final List<String> message;
    private final String totalRateOfReturn;

    public LottosResultDto(List<String> message, String totalRateOfReturn) {
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
