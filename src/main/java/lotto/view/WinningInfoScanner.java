package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.LottoSimulator.SEPARATOR;

public class WinningInfoScanner {
    Scanner sc = new Scanner(System.in);

    public List<Integer> getWinningDigits() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(sc.nextLine().split(SEPARATOR))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    public int getWinningBonusDigit() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}
