package output;

import lotto.LottoInfo;
import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultChecker {
    public static Map<Integer, Integer> getResults(List<LottoTicket> lottoTickets, List<Integer> target) {
        List<Integer> resultList = getHitCount(lottoTickets, target);
        Map<Integer, Integer> resultMap = changeResultListToMap(resultList);
        return resultMap;
    }

    private static List<Integer> getHitCount(List<LottoTicket> lottoTickets, List<Integer> target) {
        return lottoTickets.stream().map(ticket -> {
            LottoTicket retTicket = new LottoTicket(ticket.getNumbers());
            retTicket.getNumbers().retainAll(target);
            return retTicket.getNumbers().size();
        }).collect(Collectors.toList());
    }

    private static Map<Integer, Integer> changeResultListToMap(List<Integer> resultList) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        resultList.stream().forEach(res -> resultMap.put(res, resultMap.getOrDefault(res, 0) + 1));
        return resultMap.entrySet().stream()
                .filter(res -> res.getKey() >= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Integer calculateProfitRate(int purchaseFee, Map<Integer, Integer> results) {
        Integer profit = results.entrySet().stream()
                .map(a -> a.getValue() * LottoInfo.LOTTO_PRIZE.get(a.getKey()))
                .reduce((acc, a) -> acc + a).orElse(0);
        return profit * 100/purchaseFee;
    }
}
