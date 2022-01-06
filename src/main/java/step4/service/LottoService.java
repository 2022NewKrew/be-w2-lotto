package step4.service;

import step4.service.domain.WinningLotto;
import step4.util.TypeConverter;
import step4.util.Validator;
import step4.repository.LottoRepository;
import step4.service.domain.LottoBundle;
import step4.service.domain.LottoResult;
import step4.service.domain.LottoTicket;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static step4.service.LottoConfig.*;


public class LottoService {
    private LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    /**
     * 총 로또 구매 갯수 & 수동 구매 갯수
     * 입력받은 상태에서 로직만 처리. 서비스의 역할
     */
    public LottoBundle buy(int buyAmount, List<List<Integer>> selfLottoNumberList) {
        int selfAmount = selfLottoNumberList.size();
        Validator.checkSelfAmount(buyAmount, selfAmount);

        List<LottoTicket> tickets = Stream.of(buySelf(selfLottoNumberList), buyAuto(buyAmount - selfAmount))
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        return new LottoBundle(tickets);
    }


    public LottoBundle save(String id, LottoBundle tickets) {
        return lottoRepository.save(id, tickets);
    }

    public Map<Integer, Integer> matchAndGetResult(LottoBundle lottoBundle, WinningLotto winningLotto) {
        lottoBundle.getTicketBundle().stream().forEach(ticket -> winningLotto.compareAndSetResult(ticket));
        Map<Integer, Integer> resultMap = new HashMap<>();
        lottoBundle.getTicketBundle().stream().forEach(ticket -> resultMap.put(ticket.getResult().getScore(), resultMap.getOrDefault(ticket.getResult().getScore(),0) + 1));
        return resultMap;
    }

    public LottoBundle findById(String id) {
        return lottoRepository.getById(id);
    }

    public double calculateProfitRate(int amountOfTicket, Map<Integer, Integer> results) {
        int purchaseFee = LottoConfig.LOTTO_TICKET_PRICE * amountOfTicket;
        Integer profit = calculateProfit(results);
        return Math.round(((double)profit / purchaseFee) * 100 - 100);
    }


    public WinningLotto createWinningLotto(String winningNumber, String bonusNumber) {
        List<Integer> numbers = TypeConverter.StringToIntegerList(winningNumber);
        Integer bonus = TypeConverter.StringToInt(bonusNumber);
        return new WinningLotto(numbers, bonus);
    }

    // buy tickets
    private List<LottoTicket> buyAuto(int amount) {
        return IntStream.range(0, amount).mapToObj(i -> new LottoTicket(getRandomNumbers())).collect(Collectors.toList());
    }

    private List<LottoTicket> buySelf(List<List<Integer>> selfLottoNumberList) {
        return selfLottoNumberList.stream().map(LottoTicket::new).collect(Collectors.toList());
    }

    //손익금액 계산
    private Integer calculateProfit(Map<Integer, Integer> results) {
        return IntStream.rangeClosed(LottoConfig.MIN_PRIZE_KEY, LottoConfig.MAX_PRIZE_KEY)
                .map(i -> results.getOrDefault(i, 0) * LottoResult.getResult(i).getPrize())
                .reduce((acc, a) -> acc + a).orElse(0);
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> randomNums = IntStream.rangeClosed(1, BIGGEST_LOTTONUM).boxed().collect(Collectors.toList());
        Collections.shuffle(randomNums);

        randomNums = randomNums.subList(0, LOTTO_TICKET_LEN);
        Collections.sort(randomNums);

        return randomNums;
    }
}
