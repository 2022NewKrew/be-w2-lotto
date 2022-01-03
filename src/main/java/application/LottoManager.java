package application;

import view.LottoGuidePrinter;
import view.LottoScanner;

public class LottoManager {

    public static void run() {
        int purchaseQuantity = LottoScanner.getPurchaseQuantity();
        System.out.println(purchaseQuantity);
    }

}
