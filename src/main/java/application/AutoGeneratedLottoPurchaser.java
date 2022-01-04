package application;

import domain.Lotto;
import view.LottoGuidePrinter;
import view.LottoScanner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoGeneratedLottoPurchaser {
    public List<Lotto> generateLotto() {
        int quantity = inputPurchaseQuantity();

        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        return IntStream.range(0, quantity)
                .mapToObj(e -> lottoGenerator.getLotto())
                .collect(Collectors.toList());
    }

    private int inputPurchaseQuantity() {
        int purchaseQuantity = LottoScanner.getPurchaseQuantity();
        LottoGuidePrinter.alertPurchaseQuantity(purchaseQuantity);
        return purchaseQuantity;
    }
}
