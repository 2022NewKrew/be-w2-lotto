package view;

import domain.PurchasedLotto;

import javax.print.attribute.standard.PrinterURI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getManualAmount() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getManualLottoString() {
        return scanner.nextLine();
    }

    public static String getWinningLottoString() {
        return scanner.nextLine();
    }

    public static int getBonusNumber() {
        return Integer.parseInt(scanner.nextLine());
    }
    /*
    Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmountFromClient() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt()/1000;
    }

    public int getManualPurchaseAmountFromClient() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<PurchasedLotto> purchaseLotto(int manualPurchasedAmount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<PurchasedLotto> manualPurchasedLotto = new ArrayList<>();
        for (int i = 0 ; i < manualPurchasedAmount ; i++) {
            manualPurchasedLotto.add(new PurchasedLotto(getSixNumbers()));
        }
        return manualPurchasedLotto;
    }

    private List<Integer> getSixNumbers() {
        List<String> sixNumbersStrings = Arrays.asList(scanner.next().split(","));
        List<Integer> sixNumbers = new ArrayList<>();
        for (String sixNumbersString : sixNumbersStrings) {
            sixNumbers.add(Integer.parseInt(sixNumbersString));
        }
        return sixNumbers;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getSixNumbers();
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return scanner.nextInt();
    }

     */
}
