package view;

import java.util.*;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final int PRICE = 1000;
    private static final int GENERAL_INV = -1;
    private static final int INV_TOTAL_NUM = 0;
    private static final String SEPARATOR = ",";

    private InputView() {
        throw new AssertionError();
    }

    public static int getNumLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String payString=sc.next();
        int payAmount;
        try {
            payAmount = Integer.parseInt(payString);
        } catch (NumberFormatException e) {
            return INV_TOTAL_NUM;
        }
        System.out.print(Integer.max(payAmount / PRICE, 0));
        System.out.println("개를 구매했습니다.");
        return payAmount / PRICE;
    }

    public static int getManualNumLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String numString = sc.next();
        try {
            return Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            return GENERAL_INV;
        }
    }

    public static List<String> getManualNumber() {
        String WinNumbers = sc.next();
        return new ArrayList<>(Arrays.asList(WinNumbers.split(SEPARATOR)));
    }

    public static int getBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String numString = sc.next();
        try {
            return Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            return GENERAL_INV;
        }
    }
}