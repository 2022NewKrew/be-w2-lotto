package view;

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
}
