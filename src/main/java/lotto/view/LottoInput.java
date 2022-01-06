package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    public static final Scanner sc = new Scanner(System.in);

    public int moneyInput() {
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(sc.nextLine());
        return money;
    }

    public ArrayList<Integer> winningNumbersInput() {
        ArrayList<Integer> winningNumbers;
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        winningNumbers = Arrays.stream(sc.nextLine().split("\\s*,\\s*"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        return winningNumbers;
    }

    public int bonusNumberInput() {
        int bonusNumber;
        System.out.println("보너스 볼을 입력해 주세요");
        bonusNumber = Integer.parseInt(sc.nextLine());
        return bonusNumber;
    }
}
