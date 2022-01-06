package dto;

import domain.lotto.LottoTotalResult;
import domain.prize.Prize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoResultResponse {

    private final List<String> message;
    private final String totalRateOfReturn;

    public LottoResultResponse(LottoTotalResult totalResult) {
        this.message = new ArrayList<>();
        this.totalRateOfReturn = String.format("%.2f", totalResult.getEarningRatio());
        Map<Prize, Long> totalResultMap = totalResult.getLottoTotalResultMap();

        for (Prize prize : Prize.getTypeList()) {
            Long prizeCount = totalResultMap.getOrDefault(prize, 0L);
            message.add(getResultString(prize, prizeCount));
        }
    }

    private String getResultString(Prize prize, long prizeCount) {
        if (prize.isMatchedBonus()) {
            return String.format("%s개 일치, 보너스 볼 일치(%s원)- %s개", prize.getMatchedNum(), prize.getPrizeMoney(), prizeCount);
        }
        return String.format("%s개 일치 (%s원)- %s개", prize.getMatchedNum(), prize.getPrizeMoney(), prizeCount);
    }

    public List<String> getMessage() {
        return message;
    }

    public String getTotalRateOfReturn() {
        return totalRateOfReturn;
    }
}
