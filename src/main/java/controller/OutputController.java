package controller;

import domain.Lotto;
import domain.Rank;
import service.PurchaseLottoOutputService;
import service.StatsOutputService;

import java.util.List;
import java.util.Map;

public class OutputController {
    private final static PurchaseLottoOutputService purchaseLottoOutputService = new PurchaseLottoOutputService();
    private final static StatsOutputService statsOutputService = new StatsOutputService();

    public void printPurchasedLottoList(List<Lotto> lottoList, int money, int manualAmount) {
        purchaseLottoOutputService.printPurchasedLottoList(lottoList, money, manualAmount);
    }

    public void printStats(Map<Rank, Integer> stats, int money, long totalPrizeMoney) {
        statsOutputService.printStats(stats);
        statsOutputService.printYield(money, totalPrizeMoney);
    }
}
