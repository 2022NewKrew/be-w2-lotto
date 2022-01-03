package view;

import validator.ScannerValidator;

import java.util.Scanner;

public class LottoScanner {
    private static final Scanner in = new Scanner(System.in);
    
    public static int getPurchaseQuantity() {
        LottoGuidePrinter.requestPurchaseAmountInput();
        try {
            int purchaseAmount = Integer.parseInt(in.nextLine());
            ScannerValidator.assertValidPurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getPurchaseQuantity();
        }
    }
    
}
