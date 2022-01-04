package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> readLastWeeksWinningNumber() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> numbers = Arrays.asList(scanner.nextLine().split(","));

        List<Integer> newNumbers = new ArrayList<>();
        for (String number : numbers) {
            newNumbers.add(Integer.parseInt(number));
        }

        return newNumbers;
    }

    public static int readBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}