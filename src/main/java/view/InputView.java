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

    public static List<String> getWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String WinNumbers = sc.next();
        return new ArrayList<>(Arrays.asList(WinNumbers.split(SEPARATOR)));
    }

    public static int getBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}