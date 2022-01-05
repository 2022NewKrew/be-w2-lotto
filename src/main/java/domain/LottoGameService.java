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
