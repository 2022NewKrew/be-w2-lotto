package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class LottoResult {

    private final List<Integer> result;

    public LottoResult(List<Integer> result) {
        this.result = result;
    }

    public Map<Integer, Integer> getWinningResult(LottoSheet lottoSheet) {
        Map<Integer, Long> groupByResult = lottoSheet.getLottoList().stream()
                .collect(Collectors.groupingBy(this::getSingleResult, counting()));
        return groupByResult.entrySet().stream()
                .filter(e -> e.getValue() < 3)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().intValue()));
    }

    private int getSingleResult(Lotto lotto){
        return Math.toIntExact(
                lotto.getNumbers().stream()
                .filter(num -> result.contains(num))
                .count()
        );
    }
}
