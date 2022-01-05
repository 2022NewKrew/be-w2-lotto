package output;

import lotto.LottoConfig;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultChecker {
    public static Map<Integer, Integer> getResults(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        List<Integer> resultList = getHitCount(lottoTickets, winningLotto);
        Map<Integer, Integer> resultMap = changeResultListToMap(resultList);
        int secondTicketCnt = getSecondTicketCnt(lottoTickets, resultList, winningLotto.getBonusNumber());
        addSecondInfo(resultMap, secondTicketCnt);
        return resultMap;
    }
    /**
     * @param lottoTickets
     * @param winningLotto winningLotto의 보너스 번호를 제외하고 복권티켓들이 몇개의 번호를 맞췄는지 반환합니다.
     */
    private static List<Integer> getHitCount(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(ticket -> ticket.getResult().getScore())
                .collect(Collectors.toList());
    }

    /**
     * 3개 맞춘 티켓은 몇개인지, 4개 맞춘 티켓은 몇개인지 Map 형태로 반환합니다.
     * key : 3~6, value : n개의 번호를 맞춘 티켓의 갯수
     */
    private static Map<Integer, Integer> changeResultListToMap(List<Integer> resultList) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        IntStream.rangeClosed(3, LottoConfig.LOTTO_TICKET_LEN)
                .forEach(numOfHit -> resultMap.put(numOfHit, Collections.frequency(resultList, numOfHit)));

        return resultMap;
    }

    /**
     * 6개 맞춘 것을 key 6이 아닌 key 7에 저장,
     * key 6에는 5개 + 보너스번호 맞춘 2등 티켓 갯수가 들어갑니다.
     */
    private static Map<Integer, Integer> addSecondInfo(Map<Integer, Integer> results, int secondTicketCnt) {
        results.put(7, results.get(6));
        results.put(6, secondTicketCnt);
        results.put(5, results.get(5) - secondTicketCnt);
        return null;
    }

    private static int getSecondTicketCnt(List<LottoTicket> lottoTickets, List<Integer> resultList, int bonusNumber) {
        return (int) IntStream.range(0, resultList.size())
                .filter(idx -> resultList.get(idx) == 5 && lottoTickets.get(idx).getNumbers().contains(bonusNumber)).count();
    }

    public static double calculateProfitRate(int purchaseFee, Map<Integer, Integer> results) {
        Integer profit = calculateProfit(results);
        return Math.round(((double)profit / purchaseFee) * 100 - 100);
    }

    private static Integer calculateProfit(Map<Integer, Integer> results) {
        return results.entrySet().stream()
                .map(a -> a.getValue() * LottoResult.getResult(a.getKey()).getPrize())
                .reduce((acc, a) -> acc + a).orElse(0);
    }
}
