package view;

import validator.ScannerValidator;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoScanner {
    private static final Scanner in = new Scanner(System.in);

    public static int getPurchaseQuantity() {
        try {
            int purchaseAmount = Integer.parseInt(in.nextLine());
            ScannerValidator.assertValidPurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return getPurchaseQuantity();
        }
    }

    public static List<Integer> getLottoNumbers() {
        try {
            List<Integer> ballNumberList = Collections.list(new StringTokenizer(in.nextLine(), ", "))
                    .stream()
                    .map(e -> Integer.parseInt(((String) e).trim()))
                    .collect(Collectors.toList());
            ScannerValidator.assertValidBallNumbers(ballNumberList);
            return ballNumberList;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoNumbers();
        }
    }

    public static int getBonusBall(List<Integer> balls) {
        try {
            int bonusBallNumber = Integer.parseInt(in.nextLine());
            ScannerValidator.assertValidNumber(bonusBallNumber);
            ScannerValidator.assertDuplicatedBallNumber(balls, bonusBallNumber);
            return bonusBallNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusBall(balls);
        }
    }

    public static int getManualPurchaseQuantity(int totalPurchaseQuantity) {
        try {
            int manualPurchaseQuantity = Integer.parseInt(in.nextLine());
            ScannerValidator.assertValidManualPurchaseQuantity(totalPurchaseQuantity, manualPurchaseQuantity);
            return manualPurchaseQuantity;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualPurchaseQuantity(totalPurchaseQuantity);
        }
    }

    public static List<List<Integer>> getManualGeneratedLottoStrString(int purchaseQuantity) {
        try {
            return IntStream.range(0, purchaseQuantity)
                    .mapToObj(e -> getLottoNumbers())
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualGeneratedLottoStrString(purchaseQuantity);
        }
    }
}
