package controller;

import domain.Lotto;
import service.PurchaseLottoOutputService;

import java.util.List;

public class OutputController {
    private final static PurchaseLottoOutputService purchaseLottoOutputService = new PurchaseLottoOutputService();

    public void printPurchasedLottoList(List<Lotto> lottoList, int money, int manualAmount) {
        purchaseLottoOutputService.printPurchasedLottoList(lottoList, money, manualAmount);
    }
}
