package service;

import constant.LottoConstants;
import domain.Lotto;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottoOutputService {
    public void printPurchasedLottoList(List<Lotto> lottoList, int money, int manualAmount) {
        int randomAmount = money / LottoConstants.LOTTO_PRICE - manualAmount;
        String purchasedLottoListLabel = String.format("\n수동으로 %d장, 자동으로 %d장을 구매했습니다.", manualAmount, randomAmount);
        OutputView.printLabel(purchasedLottoListLabel);

        List<String> lottoStringList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            lottoStringList.add(lotto.toString());
        }
        OutputView.printPurchasedLottoListString(lottoStringList);
    }
}
