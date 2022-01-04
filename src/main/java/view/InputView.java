package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int getPurchasedMoneyFromClient() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> winningNumbersStrings = Arrays.asList(scanner.next().split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumbersString : winningNumbersStrings) {
            winningNumbers.add(Integer.parseInt(winningNumbersString));
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요");
        return scanner.nextInt();
    }
}
