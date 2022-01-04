package view;

import domain.Ball;
import domain.Lotto;
import validator.LottoValidator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoScanner {
    private static final Scanner in = new Scanner(System.in);

    public static int getPurchaseQuantity() {
        LottoGuidePrinter.requestPurchaseAmountInput();
        try {
            int purchaseAmount = Integer.parseInt(in.nextLine());
            LottoValidator.assertValidPurchaseAmount(purchaseAmount);
            return Lotto.getPurchaseQuantity(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getPurchaseQuantity();
        }
    }

    public static List<Ball> getWinningLottoNumbers() {
        LottoGuidePrinter.requestLottoNumberInput();
        try {
            List<Ball> lottoNumbers = Collections.list(new StringTokenizer(in.nextLine(), ", "))
                    .stream()
                    .map(e -> new Ball(Integer.parseInt(((String) e).trim())))
                    .collect(Collectors.toList());
            LottoValidator.assertValidLottoNumbers(lottoNumbers);
            return lottoNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLottoNumbers();
        }
    }
}
