package view;

import domain.Lotto;
import validator.ScannerValidator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoScanner {
    private static final Scanner in = new Scanner(System.in);

    public static int getPurchaseQuantity() {
        LottoGuidePrinter.requestPurchaseAmountInput();
        try {
            int purchaseAmount = Integer.parseInt(in.nextLine());
            ScannerValidator.assertValidPurchaseAmount(purchaseAmount);
            return Lotto.getPurchaseQuantity(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getPurchaseQuantity();
        }
    }

    public static List<Integer> getWinningLottoNumbers() {
        LottoGuidePrinter.requestLottoNumberInput();
        try {
            List<Integer> lottoNumbers = Collections.list(new StringTokenizer(in.nextLine(), ", "))
                    .stream()
                    .map(e -> Integer.parseInt(((String) e).trim()))
                    .collect(Collectors.toList());
            ScannerValidator.assertValidLottoNumbers(lottoNumbers);
            return lottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLottoNumbers();
        }
    }
}
