package domain;

import common.model.LottoRank;
import controller.dto.WinningResult;
import domain.model.*;
import view.dto.LottoPurchaseRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LottoGameService {

    private static final int LOTTO_PRICE = 1000;

    private static final List<Integer> BASE_LOTTO_NUMBERS = new ArrayList<>();

    public LottoGameService() {
        for(int num = 1; num < 46; num++) {
            BASE_LOTTO_NUMBERS.add(num);
        }
    }

    public LottoTickets purchase(LottoPurchaseRequest lottoPurchaseRequest) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();

        int manualLottoCount = lottoPurchaseRequest.getManualLottoCount();
        for(List<Integer> lottoNumbers : lottoPurchaseRequest.getManualLottoTickets()) {
            lottoTicketList.add(LottoTicket.from(lottoNumbers));
        }

        int amount = lottoPurchaseRequest.getAmount() - (manualLottoCount * LOTTO_PRICE);
        int quantity = calculateLottoQuantity(amount);
        for(int q = 0; q < quantity; q++) {
            lottoTicketList.add(createAutoLottoTicket());
        }

        return new LottoTickets(lottoTicketList);
    };

    private int calculateLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

    private LottoTicket createAutoLottoTicket() {
        Collections.shuffle(BASE_LOTTO_NUMBERS);
        List<Integer> lottoNumbers = new ArrayList<>(BASE_LOTTO_NUMBERS.subList(0, 6));
        Collections.sort(lottoNumbers);
        return LottoTicket.from(lottoNumbers);
    }

    /**
     * 당첨된 복권을 확인하고, 결과를 리턴한다.
     */
    public WinningResult checkWinningLotto(LottoTickets lottoTickets, WinningLottoTicket winningTicket) {
        Map<LottoRank, Integer> countMap = lottoTickets.getCountMapByRank(winningTicket);
        return new WinningResult(countMap, calculateProfitRatio(countMap, lottoTickets.getSize()));
    }

    private Integer calculateProfitRatio(Map<LottoRank, Integer> countMap, Integer countOfTicket) {
        Long profit = calculateProfit(countMap);
        Long purchaseAmount = Long.valueOf(countOfTicket * LOTTO_PRICE);
        return Long.valueOf(((profit / purchaseAmount) * 100L)).intValue();
    }

    private Long calculateProfit(Map<LottoRank, Integer> countMap) {
        return countMap.entrySet().stream()
                .mapToLong((entry) -> entry.getValue() * entry.getKey().getWinnings())
                .sum();
    }

}
