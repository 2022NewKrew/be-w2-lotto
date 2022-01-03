package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.dto.WinningResultResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {

    private final WinningNumber winningNumber;

    public WinningResult(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public WinningResultResponse winningResultRequest(List<Lotto> lottos, int lottoPrice) {
        List<Integer> matchList = lottos.stream()
                .map(lotto ->
                        lotto.getLottoNumber().stream()
                                .filter(num -> winningNumber.getWinningNumber().contains(num))
                                .count())
                .map(Long::intValue)
                .collect(Collectors.toList());

        Map<Integer, Integer> result = new HashMap<>();
        result.put(3, 0);
        result.put(4, 0);
        result.put(5, 0);
        result.put(6, 0);
        matchList.forEach(num -> result.computeIfPresent(num, (k, v) -> v+1));

        int earningRate = EarningRate.calculate(result, lottoPrice);

        return new WinningResultResponse(result, earningRate);
    }
}
