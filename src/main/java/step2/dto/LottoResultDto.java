package step2.dto;

import step2.domain.PrizeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoResultDto {
    private final Map<String, Integer> lottoPrizeToResultMap;
    private final int purchaseAmount;

    public LottoResultDto(Map<String, Integer> lottoPrizeToResultMap, int purchaseAmount) {
        this.lottoPrizeToResultMap = lottoPrizeToResultMap;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<String, Integer> getLottoPrizeToResultMap() {
        return lottoPrizeToResultMap;
    }

    public List<String> toStringList(){
        List<String> resultString = new ArrayList<>();
        Arrays.asList(PrizeType.values())
                .forEach(prizeType -> resultString.add(String.format("%s (%d원)- %d개\n",
                        prizeType.getPrintingString(),
                        prizeType.getWinningPrize(),
                        lottoPrizeToResultMap.get(prizeType.name()) == null ? 0 : lottoPrizeToResultMap.get(prizeType.name()))));
        return resultString;
    }

    public Double rateOfReturn(){
        double profit = lottoPrizeToResultMap.entrySet().stream()
                .map(e -> e.getValue() * PrizeType.valueOf(e.getKey()).getWinningPrize())
                .reduce(0, (x, y) -> x + y);
        return profit / purchaseAmount;
    }

}
