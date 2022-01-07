package step4.view.dto;

import step4.service.LottoConfig;
import step4.service.domain.LottoResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGameResult {
    private final List<String> message;
    private final String profitRate;

    public LottoGameResult(Map<Integer, Integer> results, String profitRate) {
        this.message = createMessage(results);
        this.profitRate = profitRate;
    }

    private List<String> createMessage(Map<Integer, Integer> results) {
        return IntStream.rangeClosed(LottoConfig.MIN_PRIZE_KEY, LottoConfig.MAX_PRIZE_KEY)
                .mapToObj(i -> String.format(LottoResult.getResult(i).getMessage() + results.getOrDefault(i, 0) + "개")).collect(Collectors.toList());
    }

    public List<String> getMessage() {
        return message;
    }

    public String getProfitRate() {
        return profitRate;
    }
}
