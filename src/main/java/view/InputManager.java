package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();

        return purchaseAmount;
    }

    public static List<Integer> inputWinningNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNums = scanner.nextLine();
        String[] winningNumsArray = winningNums.split(",");
        List<Integer> winningNumList = new ArrayList<>();
        for (String num : winningNumsArray) {
            winningNumList.add(Integer.parseInt(num));
        }
        return winningNumList;
    }
}
