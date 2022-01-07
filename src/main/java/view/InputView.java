package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final int PRICE = 1000;
    private static final String SEPARATOR = ",";

    private InputView() {
        throw new AssertionError();
    }

    public static int getNumLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int payAmount = sc.nextInt();
        System.out.print(Integer.max(payAmount / PRICE, 0));
        System.out.println("개를 구매했습니다.");

        return payAmount / PRICE;
    }

    public static int getManualNumLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static List<String> getManualNumber() {
        String WinNumbers = sc.next();
        return new ArrayList<>(Arrays.asList(WinNumbers.split(SEPARATOR)));
    }

    public static int getBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}