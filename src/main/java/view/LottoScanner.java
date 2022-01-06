package view;

import domain.Ball;
import validator.LottoValidator;
import validator.ScannerValidator;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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

    public static List<Ball> getWinningLottoNumbers() {
        LottoGuidePrinter.requestLottoNumberInput();
        try {
            return Collections.list(new StringTokenizer(in.nextLine(), ", "))
                    .stream()
                    .map(e -> new Ball(Integer.parseInt(((String) e).trim())))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLottoNumbers();
        }
    }

    public static Ball getBonusBall(List<Ball> balls) {
        LottoGuidePrinter.requestBonusBallInput();
        try {
            int bonusBallNumber = Integer.parseInt(in.nextLine());
            LottoValidator.assertValidNumber(bonusBallNumber);
            ScannerValidator.assertDuplicatedBallNumber(balls, bonusBallNumber);
            return new Ball(bonusBallNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusBall(balls);
        }
    }
}
