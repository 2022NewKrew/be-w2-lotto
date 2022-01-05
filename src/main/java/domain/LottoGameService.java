package domain;

import common.model.LottoRank;
import controller.dto.WinningResult;
import domain.model.*;
import domain.model.ticket.WinningLottoTicket;
import view.dto.LottoPurchaseRequest;

import java.util.Map;

public class LottoGameService {

    private static final int LOTTO_PRICE = 1000;

    public LottoTickets purchase(LottoPurchaseRequest lottoPurchaseRequest) {
        int manualLottoCount = lottoPurchaseRequest.getManualLottoCount();
        int amount = lottoPurchaseRequest.getAmount() - (manualLottoCount * LOTTO_PRICE);
        int autoLottoCount = calculateLottoQuantity(amount);

        PurchaseInfo purchaseInfo = new PurchaseInfo(autoLottoCount, manualLottoCount, lottoPurchaseRequest.getManualLottoTickets());
        return LottoTickets.createLottoTickets(purchaseInfo);
    };

    public WinningResult checkWinningLotto(LottoTickets lottoTickets, WinningLottoTicket winningTicket) {
        Map<LottoRank, Integer> countMap = lottoTickets.getCountMapByRank(winningTicket);
        return new WinningResult(countMap, calculateProfitRatio(countMap, lottoTickets.getSize()));
    }

    private int calculateLottoQuantity(int amount) {
        if(amount < 0) { throw new IllegalArgumentException("수동 금액은 구입 금액보다 작거나 같아야 합니다."); }
        return amount / LOTTO_PRICE;
    }

    private Integer calculateProfitRatio(Map<LottoRank, Integer> countMap, Integer countOfTicket) {
        Long profit = calculateProfit(countMap);
        Long purchaseAmount = Long.valueOf(countOfTicket * LOTTO_PRICE);
        return Long.valueOf(((profit / purchaseAmount) * 100L)).intValue();
    }

    private Long calculateProfit(Map<LottoRank, Integer> countMap) {
        return countMap.entrySet()
                .stream()
                .mapToLong((entry) -> entry.getValue() * entry.getKey().getWinnings())
                .sum();
    }

}
