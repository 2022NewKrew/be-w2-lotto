package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputBonusNum(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputWinningNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
